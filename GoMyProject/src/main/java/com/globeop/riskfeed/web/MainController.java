package com.globeop.riskfeed.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.OnBordDto;
import com.globeop.riskfeed.service.ClientService;
import com.globeop.riskfeed.service.OnBordService;

@Controller
public class MainController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private OnBordService onBordService;
	
    @GetMapping("/")
    public String root() {
        return "Test";
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
    
    //@GetMapping("/Add")
    @RequestMapping(value="/Add", method=RequestMethod.GET)
	public String addClientPage (Model model) {
    	System.out.println(">>>>>>##############@@@@@@@@@@@@@@");
    	model.addAttribute("SaveUpdate",new ClientTable());
		return "SaveUpdate";		
	} 
    
    
    @RequestMapping("/AddClient")
	public String saveUpdateDetails (@ModelAttribute("client") ClientTable theClientTable) {		
		try {
			theClientTable.setModified_date(new Date());
			clientService.save(theClientTable);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
    	
    	//return "SaveUpdate";
		return "redirect:/getClient";
	}
    
    
    
    
    @GetMapping("/getClient")
    public String getClient(Model model) {       
    	List<ClientTable> clientList =clientService.findAll();    	
    	model.addAttribute("clients", clientList);    	
    	return "client";
    }
    
    @GetMapping("/client/showFormForAdd")
    public String showFormForAdd(Model model) {   
    	ClientTable clientTable = new ClientTable();
    	model.addAttribute("client", clientTable);       	
    	return "client-form";
    }
    
    
    
    @GetMapping("/client/OnBordClient")
    public String showOnBordForm(Model model) {   
    	OnBordDto onBordDto = new OnBordDto();
    	model.addAttribute("onBordDto", onBordDto);       	
    	return "OnBord";
    }
    
    @RequestMapping("/AddOnBordDetails")
	public String addOnBordDetails (@ModelAttribute("OnBordDetails") OnBordDto onBordDto) {		
		try {
			onBordService.addDetails(onBordDto);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
    	
    	//return "SaveUpdate";
		return "redirect:/getClient";
	}
}
