import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernatecustomerRepositoryImpl;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.pluralsight"})
@PropertySource("app.properties") //com/pluralsight/model/app.properties
public class AppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name="customerService")
	@Scope("singleton")
	public CustomerService getCustomerService() {  // can comment this method out if using @Service("customerService") on class CustomerServiceImpl
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		
		//CustomerServiceImpl customerService = new CustomerServiceImpl(getCustomerRepository());	// constructor injection
		//customerService.setCustomerRepository(getCustomerRepository());							// setter injection
		return customerService;
	}
	
//	@Bean(name="customerRepository")
//	public CustomerRepository getCustomerRepositoy(){
//		return new HibernatecustomerRepositoryImpl();
//	}
}
