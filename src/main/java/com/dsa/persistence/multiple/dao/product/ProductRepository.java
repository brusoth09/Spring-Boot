package com.dsa.persistence.multiple.dao.product;

import com.dsa.persistence.multiple.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
