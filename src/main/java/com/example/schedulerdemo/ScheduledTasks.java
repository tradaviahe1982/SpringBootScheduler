package com.example.schedulerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.schedulerdemo.service_impls.CustomerServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Component
public class ScheduledTasks 
{
	
	@Autowired
	CustomerServiceImpl custService;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Scheduled(cron = "*/5 * * * * ?")
    public void scheduleTaskWithCronExpression() 
    {
    	custService.InsertCustomer();
    }
    /*
    3. Cron Expression
		Let’s understand the cron expression; it consists of six fields:
		
		1
		<second> <minute> <hour> <day-of-month> <month> <day-of-week> <year> <command>
		From these, <year> field is optional.
		
		3.1. Specials Characters In Expression
		* (all) – it is used to specify that event should happen for every time unit. For example, “*” in the <minute> field – means “for every minute”
		? (any) – it is utilized in the <day-of-month> and <day-of -week> fields to denote the arbitrary value – neglect the field value. For example, if we want to fire a script at “5th of every month” irrespective of what the day of the week falls on that date, then we specify a “?” in the <day-of-week> field
		– (range) – it is used to determine the value range. For example, “10-11” in <hour> field means “10th and 11th hours”
		, (values) – it is used to specify multiple values. For example, “MON, WED, FRI” in <day-of-week> field means on the days “Monday, Wednesday, and Friday”
		/ (increments) – it is used to specify the incremental values. For example, a “5/15” in the <minute> field, means at “5, 20, 35 and 50 minutes of an hour”
		L (last) – it has different meanings when used in various fields. For example, if it’s applied in the <day-of-month> field, then it means last day of the month, i.e. “31st for January” and so on as per the calendar month. It can be used with an offset value, like “L-3“, which denotes the “third to last day of the calendar month”. In the <day-of-week>, it specifies the “last day of a week”. It can also be used with another value in <day-of-week>, like “6L“, which denotes the “last Friday”
		W (weekday) – it is used to specify the weekday (Monday to Friday) nearest to a given day of the month. For example, if we specify “10W” in the <day-of-month> field, then it means the “weekday near to 10th of that month”. So if “10th” is a Saturday, then the job will be triggered on “9th”, and if “10th” is a Sunday, then it will trigger on “11th”. If you specify “1W” in the <day-of-month> and if “1st” is Saturday, then the job will be triggered on “3rd” which is Monday, and it will not jump back to the previous month
		# – it is used to specify the “N-th” occurrence of a weekday of the month, for example, “3rd Friday of the month” can be indicated as “6#3“
		3.2. Cron Expression Examples
		Let us see some examples of cron expression by using the fields and specials characters combinations:
		
		At 12:00 pm (noon) every day during the year 2017:
		
		1
		0 0 12 * * ? 2017
		Every 5 minutes starting at 1 pm and ending on 1:55 pm and then starting at 6 pm and ending at 6:55 pm, every day:
		
		1
		0 0/5 13,18 * * ?
		Every minute starting at 1 pm and ending on 1:05 pm, every day:
		
		1
		0 0-5 13 * * ?
		At 1:15 pm and 1:45 pm every Tuesday in the month of June:
		
		1
		0 15,45 13 ? 6 Tue
		At 9:30 am every Monday, Tuesday, Wednesday, Thursday, and Friday:
		
		1
		0 30 9 ? * MON-FRI
		At 9:30 am on 15th day of every month:
		
		1
		0 30 9 15 * ?
		At 6 pm on the last day of every month:
		
		1
		0 0 18 L * ?
		At 6 pm on the 3rd to last day of every month:
		
		1
		0 0 18 L-3 * ?
		At 10:30 am on the last Thursday of every month:
		
		1
		0 30 10 ? * 5L
		At 6 pm on the last Friday of every month during the years 2015, 2016 and 2017:
		
		1
		0 0 18 ? * 6L 2015-2017
		At 10 am on the third Monday of every month:
		
		1
		0 0 10 ? * 2#3
		At 12 am midnight on every day for five days starting on the 10th day of the month:
		
		1
		0 0 0 10/5 * ?
		4. Cron Special Strings
		In addition to the fields specified in the cron expression, there’s also support for some special, pre-defined values – which can be used instead of the fields:
		
		@reboot – run once at the start-up
		@yearly or @annualy – run once a year
		@monthly – run once a month
		@weekly – run once a week
		@daily or @midnight – run once a day
		@hourly – run hourly
		5. Conclusion
		In this quick article, we’ve explored about the cron jobs and crontab.
		
		We have also seen a number of expression examples you can use in your daily work, or simply infer other expressions from. 
	*/
}
