package com.petshop.mapo.service;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.DetalleVentaModel;
import com.petshop.mapo.repository.CompraRepositorio;
import com.petshop.mapo.repository.DetalleVentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DetalleVentaServicio {
    @Autowired
    private DetalleVentaRepositorio r;

    public void saveOrUpdate(DetalleVentaModel ob) {
        r.save(ob);
    }

    public List<DetalleVentaModel> getList() {
        return r.findAll();
    }
    public Optional<DetalleVentaModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
