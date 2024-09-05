package br.com.acbueno.cqrs.car.query.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.cqrs.car.query.service.CarQueryService;
import br.com.acbueno.cqrs.dto.CarResponseDTO;

@RestController
@RequestMapping("/api/queries/cars")
public class CarQueryController {

  @Autowired
  private CarQueryService carQueryService;

  @GetMapping
  public ResponseEntity<List<CarResponseDTO>> getAllCars() {
    return ResponseEntity.ok(carQueryService.getAllCars());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarResponseDTO> getCarById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(carQueryService.getCarById(id));
  }

  @GetMapping("/available")
  public ResponseEntity<List<CarResponseDTO>> getAllCarsAvaible() {
    return ResponseEntity.ok(carQueryService.listCarAvailable());
  }

}
