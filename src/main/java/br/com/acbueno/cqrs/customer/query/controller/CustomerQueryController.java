package br.com.acbueno.cqrs.customer.query.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.cqrs.customer.query.service.CustomerQueryService;
import br.com.acbueno.cqrs.dto.CustomerResponseDTO;


@RestController
@RequestMapping("/api/queries/customers")
public class CustomerQueryController {

  @Autowired
  private CustomerQueryService customerQueryService;

  @GetMapping
  public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
    return ResponseEntity.ok(customerQueryService.getAllCustomers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(customerQueryService.getCustomerById(id));
  }

}
