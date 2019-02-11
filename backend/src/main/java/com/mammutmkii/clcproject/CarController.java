package com.mammutmkii.clcproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//TODO: remove
@RestController
class CarController {
    private CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars") //fix openshift access
    public Collection<Car> coolCars() {
        ArrayList<Car> cars = new ArrayList<>();
        repository.findAll().forEach(c -> cars.add(c)); //replace with template
        return cars.stream().filter(this::isCool).collect(Collectors.toList());
    }

    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }
}