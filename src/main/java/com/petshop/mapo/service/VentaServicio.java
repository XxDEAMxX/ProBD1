package com.petshop.mapo.service;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.ProveedoresModel;
import com.petshop.mapo.model.VentaModel;
import com.petshop.mapo.repository.ProductoRepositorio;
import com.petshop.mapo.repository.ProveedoresRepositorio;
import com.petshop.mapo.repository.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VentaServicio {
    @Autowired
    private VentaRepositorio r;

    public void saveOrUpdate(VentaModel ob) {
        r.save(ob);
    }

    public List<VentaModel> getList() {
        return r.findAll();
    }
    public Optional<VentaModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
