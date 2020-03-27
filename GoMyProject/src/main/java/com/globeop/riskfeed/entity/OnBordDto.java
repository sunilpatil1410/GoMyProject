package com.globeop.riskfeed.entity;

import java.util.ArrayList;

import java.util.List;


import com.globeop.riskfeed.dto.OnBoardFunds;


public class OnBordDto {
	
	//@NotNull(message = "Please select Client")
	private int clientId;
	
	//@NotNull(message = "Please select RiskAggregator")
	private int riskAggregatorId;
	
	//@NotEmpty(message = "Please select funds")
	private String fundName;

	private String fundIds;
	
	//@NotEmpty(message = "Please select setup Date")
	private String setUpDate;
	
	private String endDate;
	
	//@NotEmpty(message = "Please select atleast one")	
	private String automationProcess;
	
	//@NotEmpty(message = "Please select atleast one")
	private String isActive;
	
	//@NotEmpty(message = "Please provide comments")
	private String comments;
	
	//@NotEmpty(message = "Please select frequency")
	private String frequency;

	
	private List<OnBoardFunds> onBoardFundsList = new ArrayList<OnBoardFunds>();
			
	
	public List<OnBoardFunds> getOnBoardFundsList() {
		return onBoardFundsList;
	}


	public void setOnBoardFundsList(List<OnBoardFunds> onBoardFundsList) {
		this.onBoardFundsList = onBoardFundsList;
	}


	public int getClientId() {
		return clientId;
	}


	public int getRiskAggregatorId() {
		return riskAggregatorId;
	}

	public void setRiskAggregatorId(int riskAggregatorId) {
		this.riskAggregatorId = riskAggregatorId;
	}
	
	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundIds() {
		return fundIds;
	}

	public void setFundIds(String fundIds) {
		this.fundIds = fundIds;
	}

	public String getSetUpDate() {
		return setUpDate;
	}

	public void setSetUpDate(String setUpDate) {
		this.setUpDate = setUpDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAutomationProcess() {
		return automationProcess;
	}

	public void setAutomationProcess(String automationProcess) {
		this.automationProcess = automationProcess;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "OnBordDto [clientId=" + clientId + ", riskAggregatorId=" + riskAggregatorId + ", fundName=" + fundName
				+ ", fundIds=" + fundIds + ", setUpDate=" + setUpDate + ", endDate=" + endDate + ", automationProcess="
				+ automationProcess + ", isActive=" + isActive + ", comments=" + comments + ", frequency=" + frequency
				+ "]";
	}
	
}
