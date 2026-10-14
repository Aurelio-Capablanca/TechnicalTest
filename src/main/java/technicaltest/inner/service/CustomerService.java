package technicaltest.inner.service;

import technicaltest.inner.model.intermediate.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findByIdentification(String identification);

}
