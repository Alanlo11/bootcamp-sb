package com.bootcamp.demo.demo_restapi;

import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_restapi.service.UserService;

// Real Service Bean -> Mocked Repository Bean
@SpringBootTest // Full scale spring context env.
public class UserServiceTest {
  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Test
  void testGetUserByUserName() {
    // Assumpution
    UserEntity userEntity =
        UserEntity.builder().name("Betty").website("betty.com").build();
    Mockito.when(this.userRepository.findByUsername("John"))
        .thenReturn(userEntity);

    // Test
    UserEntity result = this.userService.getUserByUsername("John");
    MatcherAssert.assertThat(result.getName(), is("Betty"));
    MatcherAssert.assertThat(result.getWebsite(), is("betty.com"));
  }
  
}