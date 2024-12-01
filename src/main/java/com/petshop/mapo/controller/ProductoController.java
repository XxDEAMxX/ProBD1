package com.petshop.mapo.controller;

import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<ProductosModel> getAll(){
        return productoServicio.getProductos();
    }

    @GetMapping("/{productoId}")
    public Optional<ProductosModel> getByID(@PathVariable("productoId") Long id){
        return productoServicio.getProducto(id);
    }

    @PostMapping
    public ProductosModel saveOrUpdate(@RequestBody ProductosModel productosModel){
        productoServicio.saveOrUpdate(productosModel);
        return productosModel;
    }

    @DeleteMapping("/{productoId}")
    public boolean saveOrUpdate(@PathVariable("productoId") Long id){
        productoServicio.delete(id);
        return true;
    }
}
