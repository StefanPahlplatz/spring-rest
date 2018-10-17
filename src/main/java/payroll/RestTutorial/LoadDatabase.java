package payroll.RestTutorial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import payroll.RestTutorial.employee.Employee;
import payroll.RestTutorial.employee.EmployeeRepository;
import payroll.RestTutorial.order.Order;
import payroll.RestTutorial.order.OrderRepository;
import payroll.RestTutorial.order.Status;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo", "Baggins", "Burgler")));
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo", "Baggins", "Thief")));

            orderRepository.save(new Order("Macbook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone XD", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info(("Preloaded " + order));
            });
        };
    }
}
