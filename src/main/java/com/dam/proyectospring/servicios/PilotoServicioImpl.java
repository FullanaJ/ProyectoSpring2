package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.repositorios.PilotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServicioImpl implements PilotoServicio {
    @Autowired
    private PilotoRepositorio pilotoRepositorio;


    @Override
    public List<Piloto> findAllPilotos() {
        return pilotoRepositorio.findAll();
    }

    @Override
    public Optional<Piloto> findPilotoByid(Long id) {
        return pilotoRepositorio.findByNombre(id);
    }
    @Override
    public void savePiloto(Piloto piloto) {
        pilotoRepositorio.save(piloto);
    }
    @Override
    public void deletePilotoByid(Long id) {
        pilotoRepositorio.deleteById(String.valueOf(id));
    }

}
