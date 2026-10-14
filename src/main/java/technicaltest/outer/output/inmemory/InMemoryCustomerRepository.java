package technicaltest.outer.output.inmemory;

import org.springframework.stereotype.Repository;
import technicaltest.inner.model.intermediate.Customer;

import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryCustomerRepository {

    private final Map<String, Customer> data = Map.of(
            "00000001", new Customer("00000001", "Ana Martinez", "Personal", "Activo"),
            "00000002", new Customer("00000002", "Carlos Lopez", "Empresarial", "Activo"),
            "00000003", new Customer("00000003", "Aurelio Capablanca", "Personal", "Activo")
    );

    public Optional<Customer> findById (String id) {
        return Optional.ofNullable(data.get(id));
    }

}
