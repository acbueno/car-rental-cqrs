package br.com.acbueno.cqrs.customer.model;

import java.util.ArrayList;
import java.util.List;
import br.com.acbueno.cqrs.rental.model.Rental;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "driver_license")
  private String driverLicense;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Rental> rentals = new ArrayList<>();

}
