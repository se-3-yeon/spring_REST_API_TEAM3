package org.scoula.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.employee.domain.EmployeeVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    // em_no, em_name, part, career
    private Long emNo;
    private String emName;
    private String part;
    private String career;

    // VO -> DTO
    public static EmployeeDTO of(EmployeeVO vo){
        return vo == null ? null : EmployeeDTO.builder()
                .emNo(vo.getEmNo())
                .emName(vo.getEmName())
                .part(vo.getPart())
                .career(vo.getCareer())
                .build();
    }

    // DTO -> VO
    public EmployeeVO toVo(){
        return EmployeeVO.builder()
                .emNo(emNo)
                .emName(emName)
                .part(part)
                .career(career)
                .build();
    }

}
