package com.globeop.riskfeed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globeop.riskfeed.entity.RiskAggregator;
import com.globeop.riskfeed.repository.RiskAggregatorRepository;

@Service
public class RiskAggregatorService implements CommonService<RiskAggregator> {

	private RiskAggregatorRepository riskAggregatorRepository;
	
	
	@Autowired
	public RiskAggregatorService(RiskAggregatorRepository riskAggregatorRepository) {		
		this.riskAggregatorRepository = riskAggregatorRepository;
	}

	@Override
	public List<RiskAggregator> findAll() {
		// TODO Auto-generated method stub
		return riskAggregatorRepository.findAll();
	}

	@Override
	public RiskAggregator findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(RiskAggregator theRiskAggregator) {
		riskAggregatorRepository.save(theRiskAggregator);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
