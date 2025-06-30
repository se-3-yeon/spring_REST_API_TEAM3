package org.scoula.employee.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.employee.domain.EmployeeVO;
import org.scoula.employee.dto.EmployeeDTO;
import org.scoula.employee.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    final private EmployeeMapper mapper;

    @Override
    public List<EmployeeDTO> getList() {
        log.info("getList........");

        return mapper.getList().stream()
                .map(EmployeeDTO::of)
                .toList();
    }

    @Override
    public EmployeeDTO get(Long emNo) {
        log.info("get........" + emNo);

        EmployeeDTO employee = EmployeeDTO.of(mapper.get(emNo));
        return Optional.ofNullable(employee)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(EmployeeDTO employee) {
        log.info("create........" + employee);

        EmployeeVO vo = employee.toVo();
        mapper.create(vo);
        employee.setEmNo(vo.getEmNo());
    }

    @Override
    public boolean update(EmployeeDTO employee) {
        log.info("update........" + employee);

        return mapper.update(employee.toVo()) == 1;
    }

    @Override
    public boolean delete(Long emNo) {
        log.info("delete........" + emNo);

        return mapper.delete(emNo) == 1;
    }

}
