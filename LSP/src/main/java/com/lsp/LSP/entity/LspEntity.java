package com.lsp.LSP.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class LspEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long customerId;

	private String customerName;
	private String mobileNumber;
	private String emailId;
	private String address;
	private String service;
	private String companyBusinessName;
	private Integer annualIncome;
	private String pastLoan;
	private String panCard;
	private String ImgUrl;
	@Column(nullable = false, updatable = false)
	private String customerCode;

	// No Args Constructor
	public LspEntity() {

	}

	// Prameterized Constructor
	public LspEntity(Long customerId, String customerName, String mobileNumber, String emailId, String address,
			String service, String companyBusinessName, Integer annualIncome, String pastLoan, String panCard,
			String imgUrl, String customerCode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.service = service;
		this.companyBusinessName = companyBusinessName;
		this.annualIncome = annualIncome;
		this.pastLoan = pastLoan;
		this.panCard = panCard;
		ImgUrl = imgUrl;
		this.customerCode = customerCode;
	}

	// Getters and Setters
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCompanyBusinessName() {
		return companyBusinessName;
	}

	public void setCompanyBusinessName(String companyBusinessName) {
		this.companyBusinessName = companyBusinessName;
	}

	public Integer getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Integer annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getPastLoan() {
		return pastLoan;
	}

	public void setPastLoan(String pastLoan) {
		this.pastLoan = pastLoan;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getImgUrl() {
		return ImgUrl;
	}

	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	// To String Method
	@Override
	public String toString() {
		return "LspEntity [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", address=" + address + ", service=" + service
				+ ", companyBusinessName=" + companyBusinessName + ", annualIncome=" + annualIncome + ", pastLoan="
				+ pastLoan + ", panCard=" + panCard + ", ImgUrl=" + ImgUrl + ", customerCode=" + customerCode + "]";
	}

}
