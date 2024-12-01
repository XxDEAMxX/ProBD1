package com.petshop.mapo.service;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.repository.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServicio {

    @Autowired
    private CompraRepositorio r;

    public void saveOrUpdate(CompraModel producto) {
        r.save(producto);
    }

    public List<CompraModel> getList() {
        return r.findAll();
    }
    public Optional<CompraModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
