package br.com.acbueno.cqrs.rental.model;

import java.time.LocalDate;
import br.com.acbueno.cqrs.car.model.Car;
import br.com.acbueno.cqrs.customer.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rental")
@Data
public class Rental {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "car_id", nullable = false)
  private Car car;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "rental_date")
  private LocalDate rentalDate;

  @Column(name = "return_date")
  private LocalDate returnDAte;

  @Column(name = "rental_cost")
  private Double rentalCost;

}
