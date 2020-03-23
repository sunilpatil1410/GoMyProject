package com.globeop.riskfeed.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globeop.risk.web.util.RecordNotFoundException;
import com.globeop.riskfeed.dto.LabelValueDto;
import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.FundTable;
import com.globeop.riskfeed.entity.OnBordDto;
import com.globeop.riskfeed.service.ClientService;
import com.globeop.riskfeed.service.FundService;
import com.globeop.riskfeed.service.OnBordService;

@Controller
public class MainController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private OnBordService onBordService;

	@Autowired
	private FundService fundService;

	
    @GetMapping("/")
    public String root() {
        return "index";
    }
    
    // To get the same NAV bar for all pages 
    @GetMapping({ "/Nav", "/Test/NAV" })
    public String Nav() {
        return "Nav";
    }

    @GetMapping("/login")
    public String login(Model model) {
    	model.addAttribute("date",new Date());
        //return "login";
    	return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    
    
    @RequestMapping("/Home")
	public String home () {
		
		return "index";
		
	} 
    
    @GetMapping("/Test")
    public String test() {
        return "Test";
    }
     
    

    // return list of clients available in Mysql DB
    @GetMapping("/getClient")
    public String getClient(Model model) {       
    	List<ClientTable> clientList =clientService.findAll();    	
    	model.addAttribute("clients", clientList);    	
    	return "client";
    }
    
    
         
    // return form to add new client
    @GetMapping("/AddClient")
    public String showFormForAdd(Model model) {   
    	ClientTable clientTable = new ClientTable();
    	model.addAttribute("client", clientTable);       	
    	return "client-form";
    }
    
    // Add new client and return list of clients
    @RequestMapping(value="/AddClient", method=RequestMethod.POST)
	public String saveUpdateDetails (@ModelAttribute("client") ClientTable theClientTable) {		
		try {
			System.out.println(" >>> "+theClientTable.getClientShortName());
			theClientTable.setModified_date(new Date());
			theClientTable.setClientShortName(theClientTable.getClientShortName().toUpperCase());
			clientService.save(theClientTable);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/getClient";
	}
    

    // get OnBord page
    @GetMapping("/OnBordClient")
    public String showOnBordForm(Model model) {   
    	OnBordDto onBordDto = new OnBordDto();
    	model.addAttribute("onBordDto", onBordDto);       	
    	return "OnBord";
    }
    
    // add OnBord details 
    @RequestMapping("/AddOnBordDetails")
	public String addOnBordDetails (@ModelAttribute("OnBordDetails") OnBordDto onBordDto) {		
		try {
			//System.out.println(onBordDto.getFundList());
			//onBordService.addDetails(onBordDto);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
    	
    	//return "SaveUpdate";
		return "redirect:/getClient";
	}
    
    //Testing 
    @GetMapping("/OnBordClient2/{id}")
   	public String showOnBordForm2 (@ModelAttribute("OnBordDetails") OnBordDto onBordDto, @PathVariable Integer id,Model model) {		
   		try {   			
   			//onBordService.addDetails(onBordDto);
   			model.addAttribute("onBordDto", onBordDto);    
   		} catch (Exception e) {
   			e.printStackTrace();
   			return "error";
   		}
       	
       	//return "SaveUpdate";
   		//return "redirect:/getClient";
   		return "OnBord";
   	}
    
    
    @GetMapping("/getFund")
    public String getFund(Model model) {           	
    	List<FundTable> fundTables = fundService.findAll();
    	model.addAttribute("funds", fundTables);    	
    	return "fund";
    }
    
    
    @GetMapping("/getFund/{id}")
    public String getFundById(@PathVariable Integer id,Model model) {    
    	ClientTable clientTable = clientService.findById(id);
    	List<FundTable> fundTables = fundService.findByClient(clientTable);
    	for(FundTable f:fundTables) {
    		System.out.println(f.getFundID()+">>"+f.getFundShortName());
    	}
    	model.addAttribute("funds", fundTables);
    	model.addAttribute("client", clientTable);
    	return "fund";
    }
    
    // return form to add new funds
    @GetMapping("/AddFunds")
    public String addFunds(Model model) {       	
    	OnBordDto onBordDto = new OnBordDto();
    	model.addAttribute("onBordDto", onBordDto);           	
    	return "fund-form";
    }
    
 // Add new client and return list of clients
    @RequestMapping(value="/AddFunds", method=RequestMethod.POST)
	public String addFunds (@ModelAttribute("fund") OnBordDto onBordDto) {		
		try {
			//System.out.println(theFundTable.getClientID()+" >>> "+theFundTable.getFundShortName());
			//theFundTable.setModified_date(new Date());
			//fundService.update(theFundTable);
			onBordService.addFundDetails(onBordDto);
			System.out.println(onBordDto);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/getFund/"+onBordDto.getClientId();
	}
    
    
    //@DeleteMapping("/deleteFund/{id}")
	/*
	 * @PostMapping("/delete") public String
	 * deleteEmployeeById(@RequestParam("fundId") int theId) throws
	 * RecordNotFoundException { fundService.deleteById(theId); return
	 * "redirect:/getFund/"+theId; }
	 */
    
    @GetMapping("/deleteFund")
	public String deleteFund(@RequestParam("fundID") int theFundId,@RequestParam("clientID") int theClientId) {
		
    	System.out.println("Inside delete funds");
		// delete the fund
    	
    	fundService.deleteById(theFundId);
		
		// redirect to /getFund/{}
    	return "redirect:/getFund/"+theClientId;
		
	}
}
