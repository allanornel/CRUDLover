package com.CRUDLover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUDLover.api.dto.CarDTO;
import com.CRUDLover.api.model.Car;
import com.CRUDLover.api.repository.CarRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarRepository repository;

    @PostMapping
    public void create(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @GetMapping
    public List<Car> listAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            car.setValor(req.valor());
            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
