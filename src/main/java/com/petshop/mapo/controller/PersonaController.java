package com.petshop.mapo.controller;

import com.petshop.mapo.model.PersonaModel;
import com.petshop.mapo.service.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaServicio s;

    @GetMapping
    public List<PersonaModel> getAll(){
        return s.getList();
    }

    @GetMapping("/{id}")
    public Optional<PersonaModel> getByID(@PathVariable("id") Long id){
        return s.get(id);
    }

    @PostMapping
    public PersonaModel saveOrUpdate(@RequestBody PersonaModel ob){
        s.saveOrUpdate(ob);
        return ob;
    }

    @DeleteMapping("/{id}")
    public boolean saveOrUpdate(@PathVariable("id") Long id){
        s.delete(id);
        return true;
    }
}
