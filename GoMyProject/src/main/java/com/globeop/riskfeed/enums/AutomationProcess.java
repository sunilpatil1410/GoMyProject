package com.globeop.riskfeed.enums;

public enum AutomationProcess {
	
	RiskMq("RiskMq"),
	Cron("Cron");
	
	private final String displayValue;
    
    private AutomationProcess(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
}
