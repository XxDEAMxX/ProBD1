package com.petshop.mapo.service;

import com.petshop.mapo.model.ProductosComprasModel;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.ProductosProveedoresModel;
import com.petshop.mapo.repository.ProductoCompraRepositorio;
import com.petshop.mapo.repository.ProductoProveedorRepositorio;
import com.petshop.mapo.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoProveedorServicio {
    @Autowired
    private ProductoProveedorRepositorio r;

    public void saveOrUpdate(ProductosProveedoresModel ob) {
        r.save(ob);
    }

    public List<ProductosProveedoresModel> getList() {
        return r.findAll();
    }
    public Optional<ProductosProveedoresModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
