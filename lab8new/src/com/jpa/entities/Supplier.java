package com.jpa.entities;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


/**
 * The persistent class for the Suppliers database table.
 * 
 */
@Entity
@Table(name="Suppliers")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	//these annotations are necessary! auto generate ID, otherwise id will be null. 
	@TableGenerator(name = "supplier_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "supplier_gen")
	private int supplierId;
	
	@Column(name="Address")
	private String address;


	@Column(name="City")
	private String city;


	@Column(name="ContactName")
	private String contactName;


	@Column(name="ContactTitle")
	private String contactTitle;

	@Column(name="Country")
	private String country;


	@Column(name="EmailAddress")
	private String emailAddress;


	@Column(name="FaxNumber")
	private String faxNumber;


	@Column(name="Notes")
	private String notes;


	@Column(name="PaymentTerms")
	private String paymentTerms;


	@Column(name="PhoneNumber")
	private String phoneNumber;


	@Column(name="PostalCode")
	private String postalCode;


	@Column(name="StateOrProvince")
	private String stateOrProvince;


	@Column(name="SupplierName")
	private String supplierName;

    public Supplier() {
    }

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return this.contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPaymentTerms() {
		return this.paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateOrProvince() {
		return this.stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int id) {
		this.supplierId = id;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String name) {
		this.supplierName = name;
	}


    @Override
    public String toString() {
        return supplierId  + ", " + supplierName + ", " + contactName + ", " + contactTitle + ", " + address
                + ", " + city + ", " + postalCode + ", " + stateOrProvince + ", " + country + ", " + phoneNumber
                + ", " + faxNumber + ", " + paymentTerms + ", " + emailAddress + ", " + notes;
    }

}