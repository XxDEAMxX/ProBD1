package com.petshop.mapo.service;

import com.petshop.mapo.model.GarantiaModel;
import com.petshop.mapo.model.PersonaModel;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.repository.GarantiaRepositorio;
import com.petshop.mapo.repository.PersonaRepositorio;
import com.petshop.mapo.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PersonaServicio {
    @Autowired
    private PersonaRepositorio r;

    public void saveOrUpdate(PersonaModel ob) {
        r.save(ob);
    }

    public List<PersonaModel> getList() {
        return r.findAll();
    }
    public Optional<PersonaModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
