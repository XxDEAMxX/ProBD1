package com.petshop.mapo.service;

import com.petshop.mapo.dto.VentaRegistrarDTO;
import com.petshop.mapo.model.GarantiaModel;
import com.petshop.mapo.model.ProductosModel;
import com.petshop.mapo.model.ProveedoresModel;
import com.petshop.mapo.model.VentaModel;
import com.petshop.mapo.model.detalleVenta.DetalleVentaModel;
import com.petshop.mapo.repository.*;
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

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private DetalleVentaServicio detalleVentaServicio;

    @Autowired
    private GarantiaServicio garantiaServicio;

    public void saveOrUpdate(VentaRegistrarDTO ventaRegistrarDTO) {
        // Fetch client and employee
        var cliente = personaRepositorio.findById(ventaRegistrarDTO.cliente_id()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        var empleado = personaRepositorio.findById(ventaRegistrarDTO.empleado_id()).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        // Create and save the venta object
        var venta = new VentaModel(ventaRegistrarDTO);
        venta.setCliente(cliente);
        venta.setEmpleado(empleado);
        r.save(venta); // Save venta to assign the ID

        // Process detalleVentaModelList and related entities
        ventaRegistrarDTO.detalleVentaModelList().forEach(detalleVentaRegistrarDTO -> {
            // Fetch the product
            var product = productoRepositorio.findById(detalleVentaRegistrarDTO.product_id())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            System.out.println("Product: " + product);
            // Create and save DetalleVentaModel
            var detalleVenta = new DetalleVentaModel(
                    detalleVentaRegistrarDTO.cantidad(),
                    detalleVentaRegistrarDTO.precio_unitario(),
                    product,
                    venta
            );
            System.out.println("xd");
            detalleVentaServicio.saveOrUpdate(detalleVenta);
            System.out.println("xd");


            // Create and save GarantiaModel
            var garantia = new GarantiaModel(
                    "Garantia",
                    detalleVentaRegistrarDTO.garantiaModelList().descripcion(),
                    detalleVentaRegistrarDTO.garantiaModelList().fechaEntrada(),
                    product,
                    venta // Venta with assigned ID
            );
            garantiaServicio.saveOrUpdate(garantia);
        });
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
