package com.globeop.riskfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globeop.riskfeed.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
