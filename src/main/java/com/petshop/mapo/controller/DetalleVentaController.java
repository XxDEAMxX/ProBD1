package com.petshop.mapo.controller;

import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;
import com.petshop.mapo.service.DetalleVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaServicio s;

    @GetMapping
    public List<DetalleVentaModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<DetalleVentaModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public DetalleVentaModel saveOrUpdate(@RequestBody DetalleVentaModel ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
