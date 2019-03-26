# Spring Boot Task Scheduling Example

Đây là một ví dụ khá hay về lập lịch tự động cho các tác vụ. Trước đây việc lập lịch 
luôn luôn viết dưới dạng Background bởi Windows Service. Ngày nay dưới sự hỗ trợ của
Spring Framework nó trở nên dễ dàng hơn rất nhiều.

## Yêu cầu thư viện

1. Java - 1.8.x

2. Maven - 3.x.x

## Đặt lịch theo biểu thức Cron Expression

Ví dụ vào mọi ngày lúc 0h sáng năm 2019

0 0 12 * * ? 2019