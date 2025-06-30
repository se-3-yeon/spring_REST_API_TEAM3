package org.scoula.employee.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.employee.domain.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j2
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    @DisplayName("EmployeeMapper의 목록 불러오기")
    public void getList(){
        for(EmployeeVO employee : mapper.getList()){
            log.info(employee);
        }
    }

    @Test
    @DisplayName("EmployeeMapper의 특정 정보 읽기")
    public void get(){
        EmployeeVO employee = mapper.get(1L);
        log.info(employee);
    }

    @Test
    @DisplayName("EmployeeMapper의 새 직원 추가")
    public void create(){
        EmployeeVO employee = new EmployeeVO();
        employee.setEmName("홍길동");
        employee.setPart("김치찜");
        employee.setCareer("2년차");

        mapper.create(employee);

        log.info(employee);
    }

    @Test
    @DisplayName("EmployeeMapper의 정보 수정")
    public void update(){
        EmployeeVO employee = new EmployeeVO();
        employee.setEmNo(5L);
        employee.setEmName("길동");
        employee.setPart("비냉");
        employee.setCareer("9년차");

        int count = mapper.update(employee);

        log.info("UPDATE COUNT: " + count);

    }

    @Test
    @DisplayName("EmployeeMapper의 정보 삭제")
    public void delete(){
        log.info("DELETE COUNT : " + mapper.delete(6L));
    }

}