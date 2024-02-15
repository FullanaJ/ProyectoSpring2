package com.dam.proyectospring.controladores;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.servicios.PilotoServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class APIController {
    @Autowired
    private PilotoServicio pilotoServicio;

    // GET de todos los pilotos, devuelve un JSON con todos los pilotos
    @GetMapping(value = "/pilotos")
    public ResponseEntity<List<Piloto>> getProduct()
    {
        List<Piloto> pilotos = pilotoServicio.findAllPilotos();
        return new ResponseEntity<>(pilotos, HttpStatus.OK);
    }

    // GET de un piloto, devuelve un JSON del piloto
    @GetMapping("/piloto/{id}")
    public ResponseEntity<Piloto> getProduct(@PathVariable long id) {
        return pilotoServicio.findPilotoByid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // POST de un piloto, crea un piloto
    @PostMapping("/pilotos")
    public ResponseEntity<Piloto> addProduct(@RequestBody Piloto piloto) {
        pilotoServicio.savePiloto(piloto);
        return new ResponseEntity<>(piloto, HttpStatus.OK);
    }

    // PUT de un piloto, actualiza un piloto
    @PutMapping("/pilotos")
    public ResponseEntity<Piloto> modifyProduct(@RequestBody Piloto piloto) {
        pilotoServicio.savePiloto(piloto);
        return new ResponseEntity<>(piloto, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable long id) {
        pilotoServicio.deletePilotoByid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
