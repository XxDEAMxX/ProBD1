package com.petshop.mapo.service;

import com.petshop.mapo.model.DetalleVentaModel;
import com.petshop.mapo.model.GarantiaModel;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.repository.DetalleVentaRepositorio;
import com.petshop.mapo.repository.GarantiaRepositorio;
import com.petshop.mapo.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GarantiaServicio {
    @Autowired
    private GarantiaRepositorio r;

    public void saveOrUpdate(GarantiaModel ob) {
        r.save(ob);
    }

    public List<GarantiaModel> getList() {
        return r.findAll();
    }
    public Optional<GarantiaModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
