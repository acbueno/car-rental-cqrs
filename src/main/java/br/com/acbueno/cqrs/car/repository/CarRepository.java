package br.com.acbueno.cqrs.car.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.acbueno.cqrs.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

  List<Car> findAllByAvailableTrue();

}
