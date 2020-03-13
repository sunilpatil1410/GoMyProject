package com.globeop.riskfeed.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OnBordDto {
	
	private int clientId;
	
	private String fundName;

	private List<FundTable> fundList;
	
	
	public List<FundTable> getFundList() {
		return fundList;
	}

	public void setFundList(List<FundTable> fundList) {
		this.fundList = fundList;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public void addFund(FundTable theFund) {
		if(fundList==null) {
			fundList = new ArrayList<FundTable>();
		}
		fundList.add(theFund);
        
    }
	
	

}
