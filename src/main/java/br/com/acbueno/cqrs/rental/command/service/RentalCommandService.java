package br.com.acbueno.cqrs.rental.command.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.cqrs.car.command.service.CarCommandService;
import br.com.acbueno.cqrs.car.model.Car;
import br.com.acbueno.cqrs.car.repository.CarRepository;
import br.com.acbueno.cqrs.customer.model.Customer;
import br.com.acbueno.cqrs.customer.repository.CustomerRepository;
import br.com.acbueno.cqrs.dto.CarResponseDTO;
import br.com.acbueno.cqrs.dto.RentalRequestDTO;
import br.com.acbueno.cqrs.dto.RentalResponseDTO;
import br.com.acbueno.cqrs.rental.model.Rental;
import br.com.acbueno.cqrs.rental.repository.RentalRepository;

@Service
public class RentalCommandService {

  @Autowired
  private RentalRepository rentalRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private CarCommandService carCommandService;

  @Autowired
  private ModelMapper modelMapper;

  public RentalResponseDTO allocateCar(RentalRequestDTO request) {
    //@formatter:off
    Car car = carRepository.findById(request.getCarId())
        .orElseThrow(() -> new RuntimeException("Car not found"));
    
    if(!car.isAvailable()) {
      throw new RuntimeException("Car is not available");
      
    }
    
    Customer customer = customerRepository.findById(request.getCustomerId())
        .orElseThrow(() -> new RuntimeException("Customer not found"));
    
    CarResponseDTO updatAvailableCar = carCommandService.updatAvailableCar(request.getCarId(), false);
    Rental rental = new Rental();
    rental.setCar(modelMapper.map(updatAvailableCar, Car.class));
    rental.setCustomer(customer);
    rental.setRentalDate(request.getRentalDate());
    rental.setReturnDAte(request.getReturnDate());
    rental.setRentalCost(calculateRentalCost(car, request.getRentalDate(), request.getReturnDate()));
    Rental savedRental = rentalRepository.save(rental);
    
    RentalResponseDTO response = modelMapper.map(savedRental, RentalResponseDTO.class);
    //@formatter:on

    return response;
  }

  private double calculateRentalCost(Car car, LocalDate rentalDate, LocalDate returnDate) {
    long days = ChronoUnit.DAYS.between(rentalDate, returnDate);
    return car.getPricePerDay() * days;
  }

}
