package az.nakhinternet.response;

import lombok.Data;

import java.util.List;

@Data
public class RespRoleList {

    private List<RespRole> roleList;
    private RespStatus status;
}
