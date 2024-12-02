package com.petshop.mapo.controller;

import com.petshop.mapo.dto.VentaRegistrarDTO;
import com.petshop.mapo.model.VentaModel;
import com.petshop.mapo.service.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaServicio s;

    @GetMapping
    public List<VentaModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<VentaModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public VentaRegistrarDTO saveOrUpdate(@RequestBody VentaRegistrarDTO ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
