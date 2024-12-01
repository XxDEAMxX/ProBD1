package com.petshop.mapo.controller;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.service.CompraServicio;
import com.petshop.mapo.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraServicio compraServicio;

    @GetMapping
    public List<CompraModel> getAll(){
        return compraServicio.getList();
    }

    @GetMapping("/{id}")
    public Optional<CompraModel> getByID(@PathVariable("id") Long id){
        return compraServicio.get(id);
    }

    @PostMapping
    public CompraModel saveOrUpdate(@RequestBody CompraModel compraModel){
        compraServicio.saveOrUpdate(compraModel);
        return compraModel;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        compraServicio.delete(id);
        return true;
    }
}
