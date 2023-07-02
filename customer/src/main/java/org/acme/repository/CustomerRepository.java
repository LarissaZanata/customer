package org.acme.repository;

import org.acme.entity.CustomerEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<CustomerEntity>{

}
