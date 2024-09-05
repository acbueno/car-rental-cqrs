package br.com.acbueno.cqrs.customer.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.cqrs.customer.model.Customer;
import br.com.acbueno.cqrs.customer.repository.CustomerRepository;
import br.com.acbueno.cqrs.dto.CustomerRequestDTO;
import br.com.acbueno.cqrs.dto.CustomerResponseDTO;

@Service
public class CustomerCommandService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private ModelMapper modelMapper;

  public CustomerResponseDTO addCustomer(CustomerRequestDTO request) {
    Customer entity = modelMapper.map(request, Customer.class);
    Customer saveCustomer = customerRepository.save(entity);

    return modelMapper.map(saveCustomer, CustomerResponseDTO.class);
  }

}
