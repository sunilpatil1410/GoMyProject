package com.globeop.riskfeed.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.globeop.riskfeed.GenricUtil;

@Entity  
@Table(name="ClientOnboardTable")  
public class ClientOnboardTable {

	@Id   
	@Column(name = "ClientOnboardId")
	@GeneratedValue	(strategy=GenerationType.AUTO)  
	private int ClientOnboardId;

	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ClientID")
	private ClientTable client;

	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="RiskAggregatorId")
	private RiskAggregator riskAggregator;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="FundID")
	private FundTable fund;
		
	@Column(name = "SetUpDate")
	private Date SetUpDate;
	
	@Column(name = "EndDate")
	private Date EndDate;
	
	@Column(name = "AutomationProcess")
	private String AutomationProcess;
	//private com.globeop.riskfeed.GenricUtil.AutomationProcess AutomationProcess;
	
	@Column(name = "IsActive")
	private String IsActive;
	
	@Column(name = "Comments")
	private String Comments;
	
	@Column(name = "Frequency")
	private String Frequency;
	
	@Column(name = "Modified_date")
	private Date Modified_date;
	
	
	public RiskAggregator getRiskAggregator() {
		return riskAggregator;
	}
	public void setRiskAggregator(RiskAggregator riskAggregator) {
		this.riskAggregator = riskAggregator;
	}
	
	public String getAutomationProcess() {
		return AutomationProcess;
	}
	public void setAutomationProcess(String automationProcess) {
		AutomationProcess = automationProcess;
	}
	public int getClientOnboardId() {
		return ClientOnboardId;
	}
	public void setClientOnboardId(int clientOnboardId) {
		ClientOnboardId = clientOnboardId;
	}
	public ClientTable getClient() {
		return client;
	}
	public void setClient(ClientTable client) {
		this.client = client;
	}
	public FundTable getFund() {
		return fund;
	}
	public void setFund(FundTable fund) {
		this.fund = fund;
	}
	public Date getSetUpDate() {
		return SetUpDate;
	}
	public void setSetUpDate(Date setUpDate) {
		SetUpDate = setUpDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getFrequency() {
		return Frequency;
	}
	public void setFrequency(String frequency) {
		Frequency = frequency;
	}
	public Date getModified_date() {
		return Modified_date;
	}
	public void setModified_date(Date modified_date) {
		Modified_date = modified_date;
	}
	
	
	
}
