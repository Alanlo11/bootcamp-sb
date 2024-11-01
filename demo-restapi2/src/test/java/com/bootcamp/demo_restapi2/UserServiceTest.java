package com.bootcamp.demo_restapi2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.repository.UserRepository;
import com.bootcamp.demo_restapi2.service.UserService;
import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;

// Real Service Bean -> Mocked Repository bean
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
