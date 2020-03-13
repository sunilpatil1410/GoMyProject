package com.globeop.riskfeed.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globeop.riskfeed.dto.LabelValueDto;
import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.service.ClientService;
import com.globeop.riskfeed.util.GenricUtil;

@RestController
public class AutocompleteController {
	
	@Autowired
	private ClientService clientService;
	
	private List<ClientTable> allClients;
	
	@RequestMapping(value="/clientList",method = RequestMethod.GET)
	@ResponseBody				  
	public List<LabelValueDto>/*Map<Integer, String>*/ /*List<String>*/ clientList(@RequestParam (value="term", required=false, defaultValue="") String name){
    	//System.out.println(" INSIDE clientList "+name);
		List<LabelValueDto> l= new ArrayList<LabelValueDto>();   
		Map<Integer, String> test= new HashMap<Integer, String>();
    	try {
    		if(name.length()>2) {
    			allClients = clientService.findAll();
    			//allClients = clientService.findByName(name);
    		}					
			for(ClientTable c:allClients) {
				if(c.getClientShortName().toString().contains(name.toUpperCase())) {
					//l.add(c.getClientShortName());
					//test.put(c.getClientID(), c.getClientShortName());
					LabelValueDto labelValueDto = new LabelValueDto();
					labelValueDto.setLabel(c.getClientShortName());
					labelValueDto.setValue(c.getClientID()+"");
					l.add(labelValueDto);
				}				
			}
			//System.out.println(" >> "+l);
		} catch (Exception e) {
			//e.printStackTrace();		
		}    		
    	return l;	
	}
	
	  
    @RequestMapping(value="/getFundsFromClient",method = RequestMethod.GET)
	@ResponseBody
    public List<LabelValueDto> test2(@RequestParam (value="p1", required=false, defaultValue="") String clientName) {
    	System.out.println(clientName);
    	return GenricUtil.getClientFundList(clientName);
        //return "Test";
    }
}
