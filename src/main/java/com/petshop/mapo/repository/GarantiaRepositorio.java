package com.petshop.mapo.repository;

import com.petshop.mapo.model.GarantiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarantiaRepositorio extends JpaRepository<GarantiaModel, Long> {
}
