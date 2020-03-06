package com.globeop.riskfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.globeop.riskfeed.entity.RiskAggregator;

/*@RepositoryRestResource(path ="riskAggregators")*/
public interface RiskAggregatorRepository extends JpaRepository<RiskAggregator, Integer> {

}
