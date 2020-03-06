package com.globeop.riskfeed.security.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.globeop.riskfeed.security.user.entity.User;

@Repository
//@RepositoryRestResource(path ="users")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUserName(String userName);
}
