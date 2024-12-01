package com.petshop.mapo.repository;

import com.petshop.mapo.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepositorio extends JpaRepository<CompraModel, Long> {
}
