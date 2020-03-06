package com.globeop.riskfeed.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globeop.riskfeed.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   //@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
    //public List<OrderResponse> getJoinInformation();
}
