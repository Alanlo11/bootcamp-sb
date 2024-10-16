package com.bootcamp.demo.demo_restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;


// Hibernate/ JPA
// 1. During compile time, generte class to implement this interface Class
// 2. Implement the all the method according to the DB driver
// 3. Construct the corresponding Entity Java Object
@Repository // bean
public interface UserRepository extends JpaRepository<UserEntity, Long> { // 右邊係擺pm key type
  // save() connect database -> insert into Users value(...) / similar Map.put -> create or update
  // findAll() select * from users; -> return List<User>
  // findById() -> select * from Users ehere id = ?

  // saveAll(UserEntity) -> Many insert into ... given List<UserEntity>
  // deleteById()

  // select * from Users where name = ?
  List<UserEntity> findByName(String name); // 自己玩

  // select * from Users where name = ? and website = ?
  List<UserEntity> findByNameAndWebsite(String name, String website);

  List<UserEntity> findByNameOrWebsite(String name, String website);

  
  
}