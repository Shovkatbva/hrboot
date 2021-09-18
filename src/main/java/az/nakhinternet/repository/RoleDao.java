package az.nakhinternet.repository;

import az.nakhinternet.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleDao extends CrudRepository<Role, Long> {

    List<Role> findAllByActive(Integer active);

    Role findAllByIdAndActive(Long id, Integer active);
}
