package com.bootcamp.demo.demo_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;

@Repository // bean
public interface UserRepository extends JpaRepository<UserEntity, Long> { // 右邊係擺pm key type
  // save()
}