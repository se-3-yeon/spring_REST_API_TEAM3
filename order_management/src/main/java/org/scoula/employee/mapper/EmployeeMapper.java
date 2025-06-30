package org.scoula.employee.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.employee.domain.EmployeeVO;

import java.util.List;

public interface EmployeeMapper {

//    @Select("select * from employee")
    public List<EmployeeVO> getList();

    public EmployeeVO get(Long emNo);

    public void create(EmployeeVO employee);

    public int update(EmployeeVO employee);

    public int delete(Long emNo);

}
