package az.nakhinternet.response;

import lombok.Data;

@Data
public class RespRole {
    private Long id;
    private String role_name;
    private String description;
    private RespStatus status;
}
