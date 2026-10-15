package technicaltest.inner.service;

import org.springframework.http.ResponseEntity;
import technicaltest.inner.model.intermediate.Customer;
import technicaltest.inner.model.response.GeneralResponse;

import java.util.Optional;

public interface CustomerService {

    ResponseEntity<GeneralResponse<Customer>> findByIdentification(String identification);

}
