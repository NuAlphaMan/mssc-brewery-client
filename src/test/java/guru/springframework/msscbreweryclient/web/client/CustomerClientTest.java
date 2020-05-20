package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerClientTest {
	@Autowired
	CustomerClient client;

	@Test
	void getCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());

		assertNotNull(dto);

	}

	@Test
	void testSaveCustomer() {
		//given
		CustomerDto customerDto = CustomerDto.builder().name("Jane Doe").build();

		URI uri = client.saveCustomer(customerDto);

		assertNotNull(uri);

		System.out.println(uri.toString());

	}

	@Test
	void testUpdateCustomer() {
		//given
		CustomerDto customerDto = CustomerDto.builder().name("Jane Doe").build();

		client.updateCustomer(UUID.randomUUID(), customerDto);

	}

	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}
}
