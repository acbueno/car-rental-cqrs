package br.com.acbueno.cqrs.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.acbueno.cqrs.rental.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
