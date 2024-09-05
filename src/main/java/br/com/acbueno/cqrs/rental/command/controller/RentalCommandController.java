package br.com.acbueno.cqrs.rental.command.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.cqrs.dto.RentalRequestDTO;
import br.com.acbueno.cqrs.dto.RentalResponseDTO;
import br.com.acbueno.cqrs.rental.command.service.RentalCommandService;

@RestController
@RequestMapping("/api/commands/rentals")
public class RentalCommandController {

  @Autowired
  private RentalCommandService servie;

  @PostMapping
  public ResponseEntity<RentalResponseDTO> allocateCar(@RequestBody RentalRequestDTO request) {
    RentalResponseDTO response = servie.allocateCar(request);
    return ResponseEntity.ok(response);
  }

}
