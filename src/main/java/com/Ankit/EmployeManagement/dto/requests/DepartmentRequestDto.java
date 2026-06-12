package com.Ankit.EmployeManagement.dto.requests;

import com.Ankit.EmployeManagement.validation.CreateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class DepartmentRequestDto {
    @NotNull
    String name;
    @NotNull(groups = {CreateGroup.class})
    String description;
}
