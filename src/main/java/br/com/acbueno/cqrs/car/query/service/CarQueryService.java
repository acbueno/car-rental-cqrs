package br.com.acbueno.cqrs.car.query.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import br.com.acbueno.cqrs.car.model.Car;
import br.com.acbueno.cqrs.car.repository.CarRepository;
import br.com.acbueno.cqrs.dto.CarResponseDTO;


@Service
public class CarQueryService {

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Cacheable("cars")
  public List<CarResponseDTO> getAllCars() {
    //@formatter:off
    return carRepository.findAll()
        .stream()
        .map(car -> modelMapper.map(car, CarResponseDTO.class))
        .collect(Collectors.toList());
    //@formatter:on
  }

  @Cacheable("car")
  public CarResponseDTO getCarById(Long id) {
    Car entity = carRepository.findById(id).orElseThrow(() -> new RuntimeException());
    return modelMapper.map(entity, CarResponseDTO.class);
  }

  @Cacheable("cars-available")
  public List<CarResponseDTO> listCarAvailable() {
    //@formatter:off
    return carRepository.findAllByAvailableTrue()
        .stream()
        .map(car -> modelMapper.map(car, CarResponseDTO.class))
        .collect(Collectors.toList());
  }

}
