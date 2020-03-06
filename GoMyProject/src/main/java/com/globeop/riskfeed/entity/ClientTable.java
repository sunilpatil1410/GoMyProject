package com.globeop.riskfeed.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;  

@Entity  
@Table(name="ClientTable")  
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientTable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id   
	@Column(name = "ClientID")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 	
	private int ClientID;
	
	@Column(name = "ClientShortName")
	private String ClientShortName;
	
	@Column(name = "Modified_date")
    private Date Modified_date;

	
	//@JsonManagedReference
	//@OneToMany(targetEntity = FundTable.class, cascade = CascadeType.ALL, mappedBy="client")
	
	@JsonIgnore
	@OneToMany(targetEntity = FundTable.class,fetch=FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name="ClientID")	
	private Set<FundTable> funds;
		
	/*
	 * @JsonManagedReference
	 * 
	 * @OneToMany(targetEntity = ClientOnboardTable.class, cascade =
	 * CascadeType.ALL, mappedBy="client") private Set<ClientOnboardTable>
	 * clientOnboardSet;
	 */


	public Set<FundTable> getFunds() {
		return funds;
	}

	public void setFunds(Set<FundTable> funds) {
		this.funds = funds;
	}
	

	/*
	 * public Set<ClientOnboardTable> getClientOnboardSet() { return
	 * clientOnboardSet; }
	 * 
	 * public void setClientOnboardSet(Set<ClientOnboardTable> clientOnboardSet) {
	 * this.clientOnboardSet = clientOnboardSet; }
	 */

	public int getClientID() {
		return ClientID;
	}

	public void setClientID(int clientID) {
		ClientID = clientID;
	}

	public String getClientShortName() {
		return ClientShortName;
	}

	public void setClientShortName(String clientShortName) {
		ClientShortName = clientShortName;
	}

	public Date getModified_date() {
		return Modified_date;
	}

	public void setModified_date(Date modified_date) {
		Modified_date = modified_date;
	}


	public void addFund(FundTable theFund) {
		if(funds==null) {
			funds = new HashSet<FundTable>();
		}
		theFund.setClient(this);
        this.funds.add(theFund);
    }

	@Override
	public String toString() {
		return "ClientTable [ClientID=" + ClientID + ", ClientShortName=" + ClientShortName + ", Modified_date="
				+ Modified_date + ", funds=" + funds + "]";
	}
	
	/*
	 * public void addClientOnboard(ClientOnboardTable theClientOnboardTable) {
	 * if(clientOnboardSet==null) { clientOnboardSet = new
	 * HashSet<ClientOnboardTable>(); } theClientOnboardTable.setClient(this);
	 * this.clientOnboardSet.add(theClientOnboardTable); }
	 */

	/*
	 * @Override public String toString() { return "ClientTable [ClientID=" +
	 * ClientID + ", ClientShortName=" + ClientShortName + ", Modified_date=" +
	 * Modified_date + ", funds=" + funds + ", clientOnboardSet=" + clientOnboardSet
	 * + "]"; }
	 */

	
	
    
}
