package com.petshop.mapo.service;

import com.petshop.mapo.model.productosCompras.ProductosComprasModel;
import com.petshop.mapo.repository.ProductoCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoCompraServicio {
    @Autowired
    private ProductoCompraRepositorio r;

    public void saveOrUpdate(ProductosComprasModel ob) {
        r.save(ob);
    }

    public List<ProductosComprasModel> getList() {
        return r.findAll();
    }
    public Optional<ProductosComprasModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
