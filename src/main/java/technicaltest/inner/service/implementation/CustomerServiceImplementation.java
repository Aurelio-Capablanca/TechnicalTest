package technicaltest.inner.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import technicaltest.inner.model.intermediate.Customer;
import technicaltest.inner.model.response.GeneralResponse;
import technicaltest.inner.service.CustomerService;
import technicaltest.outer.output.inmemory.InMemoryCustomerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

    private final InMemoryCustomerRepository repositoryCustomer;


    @Override
    public ResponseEntity<GeneralResponse<Customer>>   findByIdentification(String identification) {
        final Optional<Customer> customerFound = repositoryCustomer.findById(identification);
        if (customerFound.isEmpty()) {
            final GeneralResponse<Customer> response = GeneralResponse.<Customer>builder()
                    .code("404")
                    .message("No Data Found with the Id Submitted")
                    .error("No Client found at Repository")
                    .dataset(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        final GeneralResponse<Customer> response = GeneralResponse.<Customer>builder()
                .code("200")
                .message("Success data found!")
                .error(null)
                .dataset(customerFound.get())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
