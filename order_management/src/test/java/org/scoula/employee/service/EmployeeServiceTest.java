package org.scoula.employee.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.employee.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class})
@Log4j2
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    public void getList() {
        for(EmployeeDTO employee : service.getList()){
            log.info(employee);
        }
    }

    @Test
    public void get() {
        log.info(service.get(1L));
    }

    @Test
    public void create() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmName("홍길");
        employee.setPart("비빔밥");
        employee.setCareer("5년차");

        service.create(employee);

        log.info("생성된 정보 번호 : " + employee.getEmNo());
    }

    @Test
    public void update() {
        EmployeeDTO employee = service.get(1L);

        employee.setEmName("이름 수정");
        log.info("update RESULT : " + service.update(employee));
    }

    @Test
    public void delete() {
        // 게시물 번호의 존재 여부 확인하고 테스트!
        log.info("delete RESULT : " + service.delete(5L));
    }

}