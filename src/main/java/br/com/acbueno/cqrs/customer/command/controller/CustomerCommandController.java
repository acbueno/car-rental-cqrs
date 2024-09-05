package br.com.acbueno.cqrs.customer.command.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.cqrs.customer.command.service.CustomerCommandService;
import br.com.acbueno.cqrs.dto.CustomerRequestDTO;
import br.com.acbueno.cqrs.dto.CustomerResponseDTO;

@RestController
@RequestMapping("/api/commands/customers")
public class CustomerCommandController {

  @Autowired
  private CustomerCommandService service;

  @PostMapping
  public ResponseEntity<CustomerResponseDTO> createCustomer(
      @RequestBody CustomerRequestDTO request) {
    CustomerResponseDTO response = service.addCustomer(request);

    return ResponseEntity.ok(response);
  }

}
