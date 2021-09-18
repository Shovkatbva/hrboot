package az.nakhinternet.controller;

import az.nakhinternet.enums.EnumAvailableStatus;
import az.nakhinternet.model.Employee;
import az.nakhinternet.model.Role;
import az.nakhinternet.repository.EmployeeDao;
import az.nakhinternet.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value = {"/","/main"})
    public ModelAndView main() {
        ModelAndView model = new ModelAndView("index");
        List<Role> roleList = roleDao.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
        model.addObject("roleList",roleList);
        return model;
    }
@GetMapping(value = "employeeList")
    public ModelAndView employeeList(){
        ModelAndView model = new ModelAndView("/WEB-INF/pages/employee/employeeList.jsp");
        List<Employee> employeeList = employeeDao.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
        model.addObject("employeeList",employeeList);
        return model;
    }

}
