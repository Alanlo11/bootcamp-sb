package com.bootcamp.demo_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,Integer>{
  
}