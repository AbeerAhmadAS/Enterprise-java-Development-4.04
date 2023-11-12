package com.lab44.demo.Controller.Detail;

import jakarta.validation.constraints.NotEmpty;

public class EmployeeDTO {
    @NotEmpty(message = "the Status is Empty ")
    private String status;
    private String department;

    public String getDepartment() {
        return department;
    }
    public String getStatus() {
        return status;
    }

}
