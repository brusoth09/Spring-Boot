package com.dsa.respository;

import com.dsa.domain.OrderTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, Long>{
}
