package com.petshop.mapo.service;

import com.petshop.mapo.dto.VentaRegistrarDTO;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.ProveedoresModel;
import com.petshop.mapo.model.VentaModel;
import com.petshop.mapo.repository.PersonaRepositorio;
import com.petshop.mapo.repository.ProductoRepositorio;
import com.petshop.mapo.repository.ProveedoresRepositorio;
import com.petshop.mapo.repository.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VentaServicio {
    @Autowired
    private VentaRepositorio r;

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public void saveOrUpdate(VentaRegistrarDTO ventaRegistrarDTO) {
        var cliente = personaRepositorio.findById(ventaRegistrarDTO.cliente_id());
        var empleado = personaRepositorio.findById(ventaRegistrarDTO.empleado_id());

        var venta = new VentaModel(ventaRegistrarDTO);

//        venta.getGarantiaModelList().stream().map(garantiaDTO -> {
//            var garantia = new GarantiaModel(garantiaDTO);
//            garantia.setVentaModel(venta);
//            return garantia;
//        }).forEach(venta.getGarantiaModelList()::add);
        venta.setCliente(cliente.get());
        venta.setEmpleado(empleado.get());
        r.save(venta);
    }

    public List<VentaModel> getList() {
        return r.findAll();
    }
    public Optional<VentaModel> get(Long id) {
        return r.findById(id);
    }

    public void delete(Long id) {
        r.deleteById(id);
    }
}
