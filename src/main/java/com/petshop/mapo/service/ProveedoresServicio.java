package com.petshop.mapo.service;

import com.petshop.mapo.model.ProveedoresModel;
import com.petshop.mapo.repository.ProveedoresRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProveedoresServicio {
    @Autowired
    private ProveedoresRepositorio r;

    public void saveOrUpdate(ProveedoresModel ob) {
        r.save(ob);
    }

    public List<ProveedoresModel> getList() {
        return r.findAll();
    }
    public Optional<ProveedoresModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
