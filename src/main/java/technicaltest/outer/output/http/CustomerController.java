package technicaltest.outer.output.http;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technicaltest.inner.model.intermediate.Customer;
import technicaltest.inner.model.response.GeneralResponse;
import technicaltest.inner.service.CustomerService;
import technicaltest.inner.service.implementation.CustomerServiceImplementation;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    /*
     Se agrega la clase servicio desde donde se implementa el metodo de busqueda
    */
    private final CustomerServiceImplementation serviceImplementation;


    @GetMapping(value = "/{identification}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneralResponse<Customer>> getCustomer(@PathVariable @Pattern(regexp = "^[0-9]+$") @Size(min = 8) String identification) {
        return serviceImplementation.findByIdentification(identification);
    }



}
