package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {

    @SuppressWarnings("unchecked")
    Product save(Product productNew);

    List<Product> findAll();

    Product findById(long id);

    void deleteById(long id);

    Page<Product> findAll(Pageable page);

    Page<Product> findAll(Specification<Product> spe,Pageable page);
} 
