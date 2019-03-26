package com.example.schedulerdemo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="customer")	
@NamedStoredProcedureQuery
(
        name="insertCustomer",
        procedureName="insertCustomer"
)
public class CustomerCustom 
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	public Long getCustId() {
		return id;
	}

	public void setCustId(Long custId) {
		this.id = custId;
	}

	public String getCustomerName() {
		return name;
	}

	public void setCustomerName(String customerName) {
		this.name = customerName;
	}
}
