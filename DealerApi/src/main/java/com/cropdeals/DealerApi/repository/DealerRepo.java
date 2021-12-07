package com.cropdeals.DealerApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cropdeals.DealerApi.models.Dealer;
@Repository
public interface DealerRepo extends MongoRepository<Dealer, String>{
	
	@Query("{'dealerName' : ?0}")
	Dealer findOrdersByName(String itemName);
	
	@Query("{'id' : ?0}")
	Dealer findByID(String id);

}
