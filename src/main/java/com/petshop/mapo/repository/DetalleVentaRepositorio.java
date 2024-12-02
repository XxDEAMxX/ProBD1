package com.petshop.mapo.repository;

import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepositorio extends JpaRepository<DetalleVentaModel, Long> {
}
