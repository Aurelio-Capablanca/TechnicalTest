package technicaltest.inner.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import technicaltest.inner.model.intermediate.Customer;
import technicaltest.inner.service.CustomerService;
import technicaltest.outer.output.inmemory.InMemoryCustomerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

    private final InMemoryCustomerRepository repositoryCustomer;


    @Override
    public Optional<Customer> findByIdentification(String identification) {
        return Optional.empty();
    }


}
