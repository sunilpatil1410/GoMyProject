package com.globeop.riskfeed.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.globeop.riskfeed.entity.OnBordDto;

@Component
public class OnBordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OnBordDto.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		//ValidationUtils.rejectIfEmpty(errors, "fundName", "OnBordDto.fundName.empty");
		/*
		 * ValidationUtils.rejectIfEmpty(errors, "fundName",
		 * "OnBordDto.fundName.empty"); ValidationUtils.rejectIfEmpty(errors,
		 * "fundName", "OnBordDto.fundName.empty");
		 * ValidationUtils.rejectIfEmpty(errors, "fundName",
		 * "OnBordDto.fundName.empty");
		 */

	      OnBordDto onBordDto = (OnBordDto)obj;
	      System.out.println("@@@@@@@@@@@@@@");
	      System.out.println(onBordDto.getRiskAggregatorId()==-1);
	      System.out.println(onBordDto.getIsActive() == "-1");
	      System.out.println(onBordDto.getSetUpDate()=="");
	      System.out.println("@@@@@@@@@@@@@@");	     
	     
	      if(onBordDto.getRiskAggregatorId() == -1) {
	    	  errors.rejectValue("riskAggregatorId", "OnBordDto.riskAggregatorId.empty");	  
	      }
	      
	      if(onBordDto.getClientId() == 0) {
	    	  errors.rejectValue("clientId", "OnBordDto.clientId.empty");
	      }
	      
	      ValidationUtils.rejectIfEmpty(errors, "fundName", "OnBordDto.fundName.empty");
	      ValidationUtils.rejectIfEmpty(errors, "setUpDate", "OnBordDto.setUpDate.empty");

	      if(onBordDto.getAutomationProcess().equals("-1") ) {
	    	  errors.rejectValue("automationProcess", "OnBordDto.automationProcess.empty");
	      }
	      
	      if(onBordDto.getIsActive().equals("-1") ) {
	    	  errors.rejectValue("isActive", "OnBordDto.isActive.empty");
	      }
	      
	      ValidationUtils.rejectIfEmpty(errors, "frequency", "OnBordDto.frequency.empty");
	      
		/*
		 * if(onBordDto.getFundName() == "" || "".equals(onBordDto.getFundName()) ) {
		 * ValidationUtils.rejectIfEmpty(errors, "fundName",
		 * "OnBordDto.fundName.empty"); }
		 * 
		 * if(onBordDto.getClientId() == 0) { ValidationUtils.rejectIfEmpty(errors,
		 * "clientId", "OnBordDto.clientId.empty"); }
		 */

	}

}
