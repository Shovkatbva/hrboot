package az.nakhinternet.service;

import az.nakhinternet.request.ReqRole;
import az.nakhinternet.response.RespRole;
import az.nakhinternet.response.RespRoleList;
import az.nakhinternet.response.RespStatus;

public interface RoleService {

    RespRoleList getRoleList();

    RespRole getRoleById(Long roleId);

    RespStatus addRole(ReqRole reqRole);

    RespStatus updateRole(ReqRole reqRole);

    RespStatus deleteRole(Long roleId);
}
