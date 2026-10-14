package technicaltest.outer.output.inmemory;

import org.springframework.stereotype.Repository;
import technicaltest.inner.model.intermediate.Customer;

import java.util.Map;

@Repository
public class InMemoryCustomerRepository {

    private final Map<String, Customer> data = Map.of(
            "", new Customer(""),
            "", new Customer()

    );

}
