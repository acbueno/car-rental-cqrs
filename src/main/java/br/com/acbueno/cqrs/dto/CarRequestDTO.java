package br.com.acbueno.cqrs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acbueno.cqrs.car.model.Category;
import br.com.acbueno.cqrs.car.model.Type;
import lombok.Data;

@Data
public class CarRequestDTO {

  @JsonProperty("model")
  private String model;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("license-plate")
  private String licensePlate;

  @JsonProperty("available")
  private boolean available;

  @JsonProperty("year-model")
  private Integer yearModel;

  @JsonProperty("type")
  private Type type;

  @JsonProperty("cateogry")
  private Category category;

  @JsonProperty("price-per-day")
  private Double pricePerDay;

}
