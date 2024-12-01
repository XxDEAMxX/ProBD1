package com.petshop.mapo.repository;

import com.petshop.mapo.model.ProductosProveedoresModel;
import com.petshop.mapo.model.ProveedoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoProveedorRepositorio extends JpaRepository<ProductosProveedoresModel, Long> {
}
