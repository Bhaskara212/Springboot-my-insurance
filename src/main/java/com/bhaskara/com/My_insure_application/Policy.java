package com.bhaskara.com.My_insure_application;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Policy {
	
	@Id
	private int policyId;
	private String policyHolderName;
	private String policyName;
	private String ValidFrom;
	private String ValidThru;
	
	
	public Policy() {
		
	}
	public Policy(int policyId,String policyHolderName,String policyName ,String ValidFrom,String ValidThru){
		this.policyId=policyId;
		this.policyHolderName=policyHolderName;
		this.policyName=policyName;
		this.ValidFrom=ValidFrom;
		this.ValidThru=ValidThru;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getValidFrom() {
		return ValidFrom;
	}
	public void setValidFrom(String validFrom) {
		ValidFrom = validFrom;
	}
	public String getValidThru() {
		return ValidThru;
	}
	public void setValidThru(String validThru) {
		ValidThru = validThru;
	}
	
	
	

}
