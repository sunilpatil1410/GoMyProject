package com.globeop.riskfeed.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity  
@Table(name="Development")  
public class Development {

	@Id   
	@Column(name = "DevelopmentId")
	@GeneratedValue	(strategy=GenerationType.AUTO)  
	private int DevelopmentId;
	
	@Column(name = "DevelopmentHours")
	private String DevelopmentHours;
	
	@Column(name = "DevelopmentCost")
	private String DevelopmentCost;
	
	@Column(name = "IsWaivedOff")
	private String IsWaivedOff;
	
	@Column(name = "StartDate")
	private Date StartDate;
	
	@Column(name = "EndDate")
	private Date EndDate;
	
	@Column(name = "DevelopmentComments")
	private String DevelopmentComments;
	
	@Column(name = "ApprovalMail")
	private Blob ApprovalMail;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ClientID")
	private ClientTable client;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="RiskAggregatorId")
	private RiskAggregator riskAggregator;

	public int getDevelopmentId() {
		return DevelopmentId;
	}

	public void setDevelopmentId(int developmentId) {
		DevelopmentId = developmentId;
	}

	public String getDevelopmentHours() {
		return DevelopmentHours;
	}

	public void setDevelopmentHours(String developmentHours) {
		DevelopmentHours = developmentHours;
	}

	public String getDevelopmentCost() {
		return DevelopmentCost;
	}

	public void setDevelopmentCost(String developmentCost) {
		DevelopmentCost = developmentCost;
	}

	public String getIsWaivedOff() {
		return IsWaivedOff;
	}

	public void setIsWaivedOff(String isWaivedOff) {
		IsWaivedOff = isWaivedOff;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getDevelopmentComments() {
		return DevelopmentComments;
	}

	public void setDevelopmentComments(String developmentComments) {
		DevelopmentComments = developmentComments;
	}

	public Blob getApprovalMail() {
		return ApprovalMail;
	}

	public void setApprovalMail(Blob approvalMail) {
		ApprovalMail = approvalMail;
	}

	public ClientTable getClient() {
		return client;
	}

	public void setClient(ClientTable client) {
		this.client = client;
	}

	public RiskAggregator getRiskAggregator() {
		return riskAggregator;
	}

	public void setRiskAggregator(RiskAggregator riskAggregator) {
		this.riskAggregator = riskAggregator;
	}
	
	
	
	
}
