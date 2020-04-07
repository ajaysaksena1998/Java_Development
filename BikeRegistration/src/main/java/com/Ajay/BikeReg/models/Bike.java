package com.Ajay.BikeReg.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bike")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String phone;
	private String model;
	private String serial_number;
	private BigDecimal purchase_prize;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date purchase_date;
	private boolean contact;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isContact() {
		return contact;
	}
	public void setContact(boolean contact) {
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	
	public Bike(long id, String name, String email, String phone, String model, String serial_number,
			BigDecimal purchase_prize, Date purchase_date, boolean contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.model = model;
		this.serial_number = serial_number;
		this.purchase_prize = purchase_prize;
		this.purchase_date = purchase_date;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", model=" + model
				+ ", serial_number=" + serial_number + ", purchase_prize=" + purchase_prize + ", purchase_date="
				+ purchase_date + ", contact=" + contact + "]";
	}
	public BigDecimal getPurchase_prize() {
		return purchase_prize;
	}
	public void setPurchase_prize(BigDecimal purchase_prize) {
		this.purchase_prize = purchase_prize;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
}
