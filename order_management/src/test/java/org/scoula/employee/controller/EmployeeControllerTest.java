package org.scoula.employee.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.scoula.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class
})
@Log4j2
class EmployeeControllerTest {

    @Autowired
    EmployeeService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    /* list */
    @Test
    public void list() throws Exception{
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/employee/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap();

        log.info(model);
    }

    /* create */
    @Test
    void create() throws Exception{
        String viewName = mockMvc.perform(MockMvcRequestBuilders.get("/employee/create"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(viewName);
    }

    @Test
    public void postCreate() throws Exception{
        String resultPage = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/employee/create")
                                .param("emName", "테스트 새 직원 이름")
                                .param("part", "테스트 담당 음식")
                                .param("career", "테스트 경력")
                )
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }

    /* get */
    @Test
    public void get() throws Exception{
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/employee/get").param("emNo", "1"))
                .andReturn()
                .getModelAndView()
                .getModelMap();

        log.info(model);
    }

    /* update */
    @Test
    public void update() throws Exception{
        String resultPage = mockMvc.perform(
                MockMvcRequestBuilders.post("/employee/update")
                        .param("emNo", "1")
                        .param("emName", "수정된 이름")
                        .param("part", "수정된 파트")
                        .param("career", "수정된 커리어")
        )
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);
    }

    /* delete */
    @Test
    public void delete() throws Exception{
        // 번호 확인
        String resultPage = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/employee/delete")
                                .param("emNo", "7")
                )
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);
    }

}