package technicaltest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import technicaltest.inner.model.intermediate.Customer;
import technicaltest.inner.model.response.GeneralResponse;
import technicaltest.inner.service.implementation.CustomerServiceImplementation;
import technicaltest.outer.output.http.CustomerController;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ControllerTest {

    @Mock
    private CustomerServiceImplementation service;

    @InjectMocks
    private CustomerController controller;

    @Test
    void shouldReturn200WhenCustomerExists() {
        Customer customer = new Customer("00000003", "Aurelio Capablanca", "Personal", "Activo");
        when(service.findByIdentification("00000003")).thenReturn(Optional.of(customer));

        ResponseEntity<GeneralResponse<Customer>> response = controller.getCustomer("00000003");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("200", response.getBody().getCode());
        assertEquals(customer, response.getBody().getDataset());
        assertNull(response.getBody().getError());
    }

    @Test
    void shouldReturn404WhenCustomerDoesNotExist() {
        when(service.findByIdentification("99999999")).thenReturn(Optional.empty());

        ResponseEntity<GeneralResponse<Customer>> response = controller.getCustomer("99999999");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("404", response.getBody().getCode());
        assertNull(response.getBody().getDataset());
    }


}
