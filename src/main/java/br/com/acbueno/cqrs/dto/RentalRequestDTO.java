package br.com.acbueno.cqrs.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RentalRequestDTO {

  @JsonProperty("car-id")
  private Long carId;

  @JsonProperty("customer-id")
  private long customerId;

  @JsonProperty("rental-date")
  private LocalDate rentalDate;

  @JsonProperty("return-date")
  private LocalDate returnDate;

}
