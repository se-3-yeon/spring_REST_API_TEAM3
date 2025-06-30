package org.scoula.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeVO {

    // em_no, em_name, part, career
    private Long emNo;
    private String emName;
    private String part;
    private String career;

}
