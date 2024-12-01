package com.petshop.mapo.service;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public void saveOrUpdate(ProductosModel producto) {
        productoRepositorio.save(producto);
    }

    public List<ProductosModel> getProductos() {
        return productoRepositorio.findAll();
    }
    public Optional<ProductosModel> getProducto(Long id) {
        return productoRepositorio.findById(id);
    }

    public void delete(Long id) {
        productoRepositorio.deleteById(id);
    }
}
