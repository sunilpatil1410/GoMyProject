package com.globeop.riskfeed.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.globeop.riskfeed.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
