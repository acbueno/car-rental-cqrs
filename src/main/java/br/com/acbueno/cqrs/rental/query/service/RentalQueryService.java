package br.com.acbueno.cqrs.rental.query.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import br.com.acbueno.cqrs.dto.RentalResponseDTO;
import br.com.acbueno.cqrs.rental.model.Rental;
import br.com.acbueno.cqrs.rental.repository.RentalRepository;

@Service
public class RentalQueryService {

  @Autowired
  private RentalRepository rentalRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Cacheable("rentals")
  public List<RentalResponseDTO> getlAllRentals() {
    //@formatter:off
    return rentalRepository.findAll().stream()
      .map(car -> modelMapper.map(car, RentalResponseDTO.class))
      .collect(Collectors.toList());
    //@formatter:on
  }

  @Cacheable("rental")
  public RentalResponseDTO getAllocateById(Long id) {
    //@formatter:off
    Rental entity = rentalRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Allocate not found"));
    //@formatter:on
    return modelMapper.map(entity, RentalResponseDTO.class);
  }

}
