package com.petshop.mapo.controller;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.ProductosComprasModel;
import com.petshop.mapo.model.ProductosProveedoresModel;
import com.petshop.mapo.service.CompraServicio;
import com.petshop.mapo.service.ProductoCompraServicio;
import com.petshop.mapo.service.ProductoProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productosProveedor")
public class ProductosProveedorController {
    @Autowired
    private ProductoProveedorServicio s;

    @GetMapping
    public List<ProductosProveedoresModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<ProductosProveedoresModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public ProductosProveedoresModel saveOrUpdate(@RequestBody ProductosProveedoresModel ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
