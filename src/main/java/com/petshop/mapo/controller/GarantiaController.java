package com.petshop.mapo.controller;

import com.petshop.mapo.model.CompraModel;
import com.petshop.mapo.model.DetalleVentaModel;
import com.petshop.mapo.model.GarantiaModel;
import com.petshop.mapo.service.CompraServicio;
import com.petshop.mapo.service.DetalleVentaServicio;
import com.petshop.mapo.service.GarantiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/garantia")
public class GarantiaController {
    @Autowired
    private GarantiaServicio s;

    @GetMapping
    public List<GarantiaModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<GarantiaModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public GarantiaModel saveOrUpdate(@RequestBody GarantiaModel ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
