package com.globeop.riskfeed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.FundTable;
import com.globeop.riskfeed.repository.FundTableRepository;

@Service
public class FundService implements CommonService<FundTable> {
	
	@Autowired
	private FundTableRepository fundTableRepository;

	@Override
	public List<FundTable> findAll() {
		// TODO Auto-generated method stub
		List<FundTable> l=fundTableRepository.findAll();
		printList(l);
		//return fundTableRepository.findAll();
		return l;
	}

	@Override
	public FundTable findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(FundTable obj) {
		fundTableRepository.save(obj);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}


	private void printList (List<FundTable> l){
		for(Object o :l) {
			System.out.println(o.toString());
		}
	}
}
