package com.petshop.mapo.controller;

import com.petshop.mapo.model.ProveedoresModel;
import com.petshop.mapo.service.ProveedoresServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresServicio s;

    @GetMapping
    public List<ProveedoresModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<ProveedoresModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public ProveedoresModel saveOrUpdate(@RequestBody ProveedoresModel ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
