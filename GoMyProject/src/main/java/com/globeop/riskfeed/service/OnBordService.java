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
}
