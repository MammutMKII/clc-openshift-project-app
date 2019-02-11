package com.mammutmkii.clcproject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TODO: remove
@Repository
public interface CarRepository extends CrudRepository<Car, String> {
}
