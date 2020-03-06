package com.globeop.riskfeed.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.Customer;
import com.globeop.riskfeed.entity.Employee;
import com.globeop.riskfeed.entity.FundTable;
import com.globeop.riskfeed.entity.RiskAggregator;
import com.globeop.riskfeed.repository.CustomerRepository;
import com.globeop.riskfeed.repository.EmployeeRepository;
import com.globeop.riskfeed.repository.ProductRepository;
import com.globeop.riskfeed.service.ClientService;
import com.globeop.riskfeed.service.FundService;
import com.globeop.riskfeed.service.RiskAggregatorService;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	private RiskAggregatorService riskAggregatorService;

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private FundService fundService;
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
	
    
    

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }
    
	/*
	 * @Autowired public TestController(RiskAggregatorService riskAggregatorService,
	 * ClientService clientService) { this.riskAggregatorService =
	 * riskAggregatorService; this.clientService = clientService; }
	 */

	/*
	 * @Autowired public TestController(RiskAggregatorService riskAggregatorService)
	 * { this.riskAggregatorService = riskAggregatorService; }
	 * 
	 * 
	 * @Autowired public TestController(ClientService clientService) {
	 * this.clientService = clientService; }
	 */



	@GetMapping("/riskaggregator")
	public List<RiskAggregator> riskaggregator () {	
		return riskAggregatorService.findAll();		
	} 
	
	@GetMapping("/client")
	public List<ClientTable> client () {	
		return clientService.findAll();		
	} 
	
	@GetMapping("/client2")
	public List<String> client2 () {	
		return clientService.findAll1();		
	}
	@GetMapping("/fund")
	public List<FundTable> fund () {	
		return fundService.findAll();		
	} 
	
	@GetMapping("/emp")
	public List<Employee> employee () {	
		return EmployeeRepository.findAll();		
	} 
}
