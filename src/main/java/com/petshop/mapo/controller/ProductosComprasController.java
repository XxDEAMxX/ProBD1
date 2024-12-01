package com.petshop.mapo.controller;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.PersonaModel;
import com.petshop.mapo.model.ProductosComprasModel;
import com.petshop.mapo.service.CompraServicio;
import com.petshop.mapo.service.PersonaServicio;
import com.petshop.mapo.service.ProductoCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productosCompras")
public class ProductosComprasController {
    @Autowired
    private ProductoCompraServicio s;

    @GetMapping
    public List<ProductosComprasModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<ProductosComprasModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public ProductosComprasModel saveOrUpdate(@RequestBody ProductosComprasModel ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
