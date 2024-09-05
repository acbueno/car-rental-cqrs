package br.com.acbueno.cqrs.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.cqrs.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
