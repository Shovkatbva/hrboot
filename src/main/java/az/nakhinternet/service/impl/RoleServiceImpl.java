package az.nakhinternet.service.impl;


import az.nakhinternet.enums.EnumAvailableStatus;
import az.nakhinternet.model.Role;
import az.nakhinternet.repository.RoleDao;
import az.nakhinternet.request.ReqRole;
import az.nakhinternet.response.RespRole;
import az.nakhinternet.response.RespRoleList;
import az.nakhinternet.response.RespStatus;
import az.nakhinternet.service.RoleService;
import az.nakhinternet.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public RespRoleList getRoleList() {
        RespRoleList response = new RespRoleList();
        List<RespRole> respRoles = new ArrayList<>();
        try {
            //List<Role> roleList = roleDao.getRoleList();
            List<Role> roleList = (List<Role>) roleDao.findAllByActive(1);
            if (roleList.isEmpty()) {
                response.setStatus(new RespStatus(ExceptionConstants.ROlE_NOT_FOUND, "ROLE NOT FOUND"));
                return response;
            }
            for (Role role : roleList) {
                RespRole respRole = new RespRole();
                respRole.setId(role.getId());
                respRole.setRole_name(role.getRole_name());
                respRole.setDescription(role.getDescription());
                respRoles.add(respRole);
            }
            response.setRoleList(respRoles);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public RespRole getRoleById(Long roleId) {
        RespRole response = new RespRole();
        try {
            if (roleId == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid requset data"));
                return response;
            }
            Role role = roleDao.findAllByIdAndActive(roleId, EnumAvailableStatus.ACTIVE.getValue());
            if (role == null) {
                response.setStatus(new RespStatus(ExceptionConstants.ROlE_NOT_FOUND, "Role not found"));
                return response;
            }
            response.setId(role.getId());
            response.setRole_name(role.getRole_name());
            response.setDescription(role.getDescription());
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal exception"));
        }
        return response;
    }

    @Override
    public RespStatus addRole(ReqRole reqRole) {
        RespStatus response = null;
        String role_name = reqRole.getRole_name();
        String description = reqRole.getDescription();
        try {
            if (role_name == null || description == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Requset data");
            }
            Role role = new Role();
            role.setRole_name(role_name);
            role.setDescription(description);
            roleDao.save(role);
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal exception");
        }
        return response;
    }

    @Override
    public RespStatus updateRole(ReqRole reqRole) {
        RespStatus response = null;
        Long roleId = reqRole.getRoleId();
        String role_name = reqRole.getRole_name();
        String description = reqRole.getDescription();
        try {
            if (roleId == null || role_name == null || description == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Requset data");
            }
            Role role = roleDao.findAllByIdAndActive(roleId, EnumAvailableStatus.ACTIVE.getValue());
            if (role == null) {
                return new RespStatus(ExceptionConstants.ROlE_NOT_FOUND, "Role not found");
            }
            role.setRole_name(role_name);
            role.setDescription(description);
            roleDao.save(role);
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal exception");
        }
        return response;
    }

    @Override
    public RespStatus deleteRole(Long roleId) {
        RespStatus response = null;
        try {
            if (roleId == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Requset data");
            }
            Role role = roleDao.findAllByIdAndActive(roleId, EnumAvailableStatus.ACTIVE.getValue());
            if (role == null) {
                return new RespStatus(ExceptionConstants.ROlE_NOT_FOUND, "Role not found");

            }
            role.setActive(EnumAvailableStatus.DEACTIVE.getValue());
            roleDao.save(role);
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal exception");
        }
        return response;
    }
}
