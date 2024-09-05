package br.com.acbueno.cqrs.car.command.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.cqrs.car.command.service.CarCommandService;
import br.com.acbueno.cqrs.dto.CarRequestDTO;
import br.com.acbueno.cqrs.dto.CarResponseDTO;

@RestController
@RequestMapping("/api/commands/cars")
public class CarCommandController {

  @Autowired
  private CarCommandService carCommandService;

  @PostMapping
  public ResponseEntity<CarResponseDTO> createCar(@RequestBody CarRequestDTO request) {
    CarResponseDTO carResponseDTO = carCommandService.addCar(request);
    return ResponseEntity.ok(carResponseDTO);
  }

  @PutMapping("/{idCar}")
  public ResponseEntity<CarResponseDTO> updateCarAvailable(@PathVariable("idCar") Long idCar,
      @RequestParam Boolean available) {
    return ResponseEntity.ok(carCommandService.updatAvailableCar(idCar, available));
  }

}
