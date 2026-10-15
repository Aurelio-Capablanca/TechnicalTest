package technicaltest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import technicaltest.inner.model.intermediate.Customer;
import technicaltest.inner.service.implementation.CustomerServiceImplementation;
import technicaltest.outer.output.inmemory.InMemoryCustomerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ServiceTest {


    @Mock
    private InMemoryCustomerRepository repository;
    @InjectMocks
    private CustomerServiceImplementation serviceImplementation;


    @Test
    void shouldFindData() {
        Customer expected = new Customer("00000003", "Aurelio Capablanca", "Personal", "Activo");
        when(repository.findById("00000003"))
                .thenReturn(Optional.of(expected));

        Optional<Customer> customer = serviceImplementation.findByIdentification("00000003");

        assertTrue(customer.isPresent());
        assertEquals("Aurelio Capablanca", customer.get().nombreCompleto());
        verify(repository).findById("00000003");
    }

    @Test
    void shouldNotFindData() {
       when(repository.findById("909090909")).thenReturn(Optional.empty());
       assertTrue(serviceImplementation.findByIdentification("909090909").isEmpty());
    }

}
