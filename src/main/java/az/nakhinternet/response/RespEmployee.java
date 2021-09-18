package az.nakhinternet.response;

import lombok.Data;

import java.sql.Blob;

@Data
public class RespEmployee {
    private Long id;
    private String name;
    private String surname;
    private String father_name;
    private String dob;
    private String note;
    private RespOsp respOsp;
    private Blob picture;
}
