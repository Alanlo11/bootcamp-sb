package com.bootcamp.demo_restapi2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.demo_restapi2.controller.impl.BankUserController;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.mapper.BankMapper;
import com.bootcamp.demo_restapi2.mapper.GovMapper;
import com.bootcamp.demo_restapi2.service.UserService;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {BankUserController.class}) //特定試邊個class
// A Test spring env,
// consist of controller beans + some other bean for test (MockMvc)
public class BankUserControllerTest {
  @Autowired
  private MockMvc mockMvc; // Postman

  // ! @Mock, @Autowired
  @MockBean
  private UserService userService;

  // In order to create the bean of BankUserController for this testing env,
  // BankMapper bean is required
  // we have to add Bankmapper explicitly
  @SpyBean
  private BankMapper bankMapper;

  // @SpyBean
  // private GovMapper govMapper;

  @Test
  void testGetUserByUserName() throws Exception {
    // Postman -> URL -> Spring Boot Controller -> Service

    // Assumption
    UserEntity userEntity =
        UserEntity.builder().name("Betty").website("betty.com").build();
    Mockito.when(this.userService.getUserByUsername("John"))
        .thenReturn(userEntity);

    // Test
    this.mockMvc.perform(get("/user").param("username", "John"))
        .andExpect(status().isOk()) //
        .andExpect(jsonPath("$.code", is("000000"))) //
        .andExpect(jsonPath("$.message", is("Success."))) //
        .andExpect(jsonPath("$.data.[*].name").value(hasItem("Betty"))) //
        .andExpect(jsonPath("$.data.[*].website").value(hasItem("betty.com")));
  }

  // post, delete, put

}
