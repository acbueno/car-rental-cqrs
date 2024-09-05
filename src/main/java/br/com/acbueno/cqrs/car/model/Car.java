package br.com.acbueno.cqrs.car.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("model")
  private String model;

  @Column(name = "brand")
  private String brand;

  @Column(name = "license_plate")
  private String licensePlate;

  @Column(name = "available")
  private boolean available;

  @Column(name = "year_model")
  private Integer yearModel;

  @Enumerated(EnumType.STRING)
  private Type type;

  @Enumerated(EnumType.STRING)
  private Category category;

  @Column(name = "price_per_day")
  private Double pricePerDay;

}
