package com.spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="customer_phone", nullable=false)
	private long customerPhone;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Lead> leads;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerEmail=" + customerEmail + ", leads=" + leads + "]";
	}
	
}
