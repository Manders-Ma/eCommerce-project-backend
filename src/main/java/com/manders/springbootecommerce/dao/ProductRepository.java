package com.manders.springbootecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.manders.springbootecommerce.entity.Product;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
  // similar to "select * from product where category_id=?"
  
  // spring data rest automatically exposes endpoint to
  // http://localhost:8080/api/products/search/findByCategoryId?id=1
  Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
  
  
  // similar to "select * from Product p where p.name like concat('%', :name, '%')"
  Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
}
