package br.com.acbueno.cqrs.rental.query.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.cqrs.dto.RentalResponseDTO;
import br.com.acbueno.cqrs.rental.query.service.RentalQueryService;

@RestController
@RequestMapping("/api/queries/rentals")
public class RentalQueryController {

  @Autowired
  private RentalQueryService rentalQueryService;

  @GetMapping
  public ResponseEntity<List<RentalResponseDTO>> getAllRental() {
    return ResponseEntity.ok(rentalQueryService.getlAllRentals());
  }

  @GetMapping("/{id}")
  public ResponseEntity<RentalResponseDTO> getAllocatedById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(rentalQueryService.getAllocateById(id));
  }

}
