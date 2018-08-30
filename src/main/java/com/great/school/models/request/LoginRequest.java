package com.great.school.models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Kibet on 27-Nov-17.
 */
@Data
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
