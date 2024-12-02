package com.petshop.mapo.repository;

import com.petshop.mapo.model.productosCompras.ProductosComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCompraRepositorio extends JpaRepository<ProductosComprasModel, Long> {
}
