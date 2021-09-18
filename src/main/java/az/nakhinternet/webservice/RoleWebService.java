package az.nakhinternet.webservice;

import az.nakhinternet.request.ReqRole;
import az.nakhinternet.response.RespRole;
import az.nakhinternet.response.RespRoleList;
import az.nakhinternet.response.RespStatus;
import az.nakhinternet.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleWebService {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "getRoleList")
    public RespRoleList getRoleList() {
        return roleService.getRoleList();
    }

    @GetMapping(value = "getRoleById")
    public RespRole getRoleById(@RequestParam("roleId") Long roleId) {
        return roleService.getRoleById(roleId);
    }

    @PostMapping(value = "addRole")
    public RespStatus addRole(@RequestBody ReqRole reqRole) {
        return roleService.addRole(reqRole);
    }

    @PutMapping(value = "/updateRole")
    public RespStatus updateRole(@RequestBody ReqRole reqRole){
        return roleService.updateRole(reqRole);
    }

    @PutMapping(value = "/deleteRole/{roleId}")
    public RespStatus deleteRole(@PathVariable("roleId")Long roleId){
        return roleService.deleteRole(roleId);
    }
}
