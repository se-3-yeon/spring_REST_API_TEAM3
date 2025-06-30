package org.scoula.employee.service;

import org.scoula.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDTO> getList();

    public EmployeeDTO get(Long emNo);

    public void create(EmployeeDTO employee);

    public boolean update(EmployeeDTO employee);

    public boolean delete(Long emNo);

}
