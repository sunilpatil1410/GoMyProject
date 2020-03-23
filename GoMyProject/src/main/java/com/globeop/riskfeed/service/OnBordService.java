package com.globeop.riskfeed.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.FundTable;
import com.globeop.riskfeed.entity.OnBordDto;

@Service
public class OnBordService {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private FundService fundService;
	
	public void addDetails(OnBordDto onBordDto) {
				
		ClientTable client=clientService.findById(onBordDto.getClientId());
		
		System.out.println("@@@@@@@@@@@@@ "+client.getClientShortName());
		FundTable fund = new FundTable();
		fund.setFundShortName(onBordDto.getFundName());
		fund.setModified_date(new Date());
		//fund.setClient(client);
		
		client.addFund(fund);
		
		clientService.save(client);
		
		//fundService.save(fund);
	}
	
	
	public void addFundDetails(OnBordDto onBordDto) {
		ClientTable client=clientService.findById(onBordDto.getClientId());
		String fundNames=onBordDto.getFundName();
		if(fundNames.startsWith(",")){
			fundNames=onBordDto.getFundName().substring(1,fundNames.length());
		}
		String Funds[]=fundNames.split(",");
		for(String s: Funds) {
			FundTable fund = new FundTable();
			System.out.println("@@@ "+s);
			fund.setModified_date(new Date());
			fund.setFundShortName(s);
			client.addFund(fund);
		}		
		clientService.save(client);
	}
}
