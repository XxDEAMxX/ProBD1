package com.petshop.mapo.repository;

import com.petshop.mapo.model.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<ProductosModel, Long> {

}
