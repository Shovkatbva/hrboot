package az.nakhinternet.repository;

import az.nakhinternet.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Long> {

    List<Employee> findAllByActive(Integer active);
}
