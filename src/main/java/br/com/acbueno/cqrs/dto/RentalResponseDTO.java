package br.com.acbueno.cqrs.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RentalResponseDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("car")
  private CarResponseDTO car;

  @JsonProperty("customer")
  private CustomerRequestDTO customer;

  @JsonProperty("rental-date")
  private LocalDate rentalDate;

  @JsonProperty("return-date")
  private LocalDate returnDate;

  @JsonProperty("rental-cost")
  private double rentalCost;

}
