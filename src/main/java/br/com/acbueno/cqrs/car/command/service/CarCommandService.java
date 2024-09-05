package br.com.acbueno.cqrs.car.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.cqrs.car.model.Car;
import br.com.acbueno.cqrs.car.repository.CarRepository;
import br.com.acbueno.cqrs.dto.CarRequestDTO;
import br.com.acbueno.cqrs.dto.CarResponseDTO;

@Service
public class CarCommandService {

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private ModelMapper modelMapper;

  public CarResponseDTO addCar(CarRequestDTO request) {
    Car entity = modelMapper.map(request, Car.class);
    Car saveCar = carRepository.save(entity);

    return modelMapper.map(saveCar, CarResponseDTO.class);
  }

  public CarResponseDTO updatAvailableCar(Long id, boolean available) {
    Car entity =
        carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    entity.setAvailable(available);
    carRepository.save(entity);

    return modelMapper.map(entity, CarResponseDTO.class);
  }

}
