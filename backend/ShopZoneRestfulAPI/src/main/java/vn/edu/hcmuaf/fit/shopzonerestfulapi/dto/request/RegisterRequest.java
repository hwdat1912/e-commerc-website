package vn.edu.hcmuaf.fit.shopzonerestfulapi.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phone;

}
