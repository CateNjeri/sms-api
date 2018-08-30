package com.great.school.models.request;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.great.school.models.data.School;
import com.great.school.models.data.UserAccount;
import lombok.Data;

/**
 * Created by Kibet on 27-Nov-17.
 */
@Data
public class RegisterUserAccountRequest {
    private School school;
    private UserAccount userAccount;
}
