package br.com.acbueno.cqrs.customer.query.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import br.com.acbueno.cqrs.customer.model.Customer;
import br.com.acbueno.cqrs.customer.repository.CustomerRepository;
import br.com.acbueno.cqrs.dto.CustomerResponseDTO;


@Service
public class CustomerQueryService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Cacheable("customers")
  public List<CustomerResponseDTO> getAllCustomers() {
    //@formatter:off
    return customerRepository.findAll()
        .stream()
        .map(customer -> modelMapper.map(customer, CustomerResponseDTO.class))
        .collect(Collectors.toList());
    //@formatter:on
  }

  @Cacheable("customer")
  public CustomerResponseDTO getCustomerById(Long id) {
    Customer entity = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));
    return modelMapper.map(entity, CustomerResponseDTO.class);
  }

}
