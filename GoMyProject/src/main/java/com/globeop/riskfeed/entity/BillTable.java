package com.globeop.riskfeed.entity;

import java.util.Date;

public class BillTable {
	private int BillId ;
	private int SetupFee ;
	private int MonthlyFee ;
	private int DevlopementFee;
	private String IsClientPayingOldCharge;
	private String IsWaived;
	private String WaiverComments;
	private Date BillStartDate;
	private Date BillEndDate;
	
	//private String ClientId;
	//private int RiskAggregatorId;
	private RiskAggregator riskAggregator;
	
	private String CRMName;
	private String CRMEmailID;
	private String ClientApprovalMail;
	private String BillingComments;
	private String GoCheckNoteId;
	private String TerminationMail;
	private int Fundcount;
	
	private ClientTable client;
	//private RiskAggregator riskAggregator;
	
	
	
	
	public int getSetupFee() {
		return SetupFee;
	}
	public RiskAggregator getRiskAggregator() {
		return riskAggregator;
	}
	public void setRiskAggregator(RiskAggregator riskAggregator) {
		this.riskAggregator = riskAggregator;
	}
	public int getBillId() {
		return BillId;
	}
	public void setBillId(int billId) {
		BillId = billId;
	}
	
	public void setSetupFee(int setupFee) {
		SetupFee = setupFee;
	}
	public int getMonthlyFee() {
		return MonthlyFee;
	}
	public void setMonthlyFee(int monthlyFee) {
		MonthlyFee = monthlyFee;
	}
	public int getDevlopementFee() {
		return DevlopementFee;
	}
	public void setDevlopementFee(int devlopementFee) {
		DevlopementFee = devlopementFee;
	}
	public String getIsClientPayingOldCharge() {
		return IsClientPayingOldCharge;
	}
	public void setIsClientPayingOldCharge(String isClientPayingOldCharge) {
		IsClientPayingOldCharge = isClientPayingOldCharge;
	}
	public String getIsWaived() {
		return IsWaived;
	}
	public void setIsWaived(String isWaived) {
		IsWaived = isWaived;
	}
	public String getWaiverComments() {
		return WaiverComments;
	}
	public void setWaiverComments(String waiverComments) {
		WaiverComments = waiverComments;
	}
	public Date getBillStartDate() {
		return BillStartDate;
	}
	public void setBillStartDate(Date billStartDate) {
		BillStartDate = billStartDate;
	}
	public Date getBillEndDate() {
		return BillEndDate;
	}
	public void setBillEndDate(Date billEndDate) {
		BillEndDate = billEndDate;
	}
	public String getCRMName() {
		return CRMName;
	}
	public void setCRMName(String cRMName) {
		CRMName = cRMName;
	}
	public String getCRMEmailID() {
		return CRMEmailID;
	}
	public void setCRMEmailID(String cRMEmailID) {
		CRMEmailID = cRMEmailID;
	}
	public String getClientApprovalMail() {
		return ClientApprovalMail;
	}
	public void setClientApprovalMail(String clientApprovalMail) {
		ClientApprovalMail = clientApprovalMail;
	}
	public String getBillingComments() {
		return BillingComments;
	}
	public void setBillingComments(String billingComments) {
		BillingComments = billingComments;
	}
	public String getGoCheckNoteId() {
		return GoCheckNoteId;
	}
	public void setGoCheckNoteId(String goCheckNoteId) {
		GoCheckNoteId = goCheckNoteId;
	}
	public String getTerminationMail() {
		return TerminationMail;
	}
	public void setTerminationMail(String terminationMail) {
		TerminationMail = terminationMail;
	}
	public int getFundcount() {
		return Fundcount;
	}
	public void setFundcount(int fundcount) {
		Fundcount = fundcount;
	}
	public ClientTable getClient() {
		return client;
	}
	public void setClient(ClientTable client) {
		this.client = client;
	}
	
	
	
	
}
