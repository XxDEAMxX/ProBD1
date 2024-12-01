package com.petshop.mapo.repository;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<PersonaModel, Long> {
}
