package com.petshop.mapo.repository;

import com.petshop.mapo.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends JpaRepository<VentaModel, Long> {
}
