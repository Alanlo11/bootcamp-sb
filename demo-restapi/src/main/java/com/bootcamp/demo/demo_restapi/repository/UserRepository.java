package com.bootcamp.demo.demo_restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;


// Hibernate/ JPA
// 1. During compile time, generte class to implement this interface Class
// 2. Implement the all the method according to the DB driver
// 3. Construct the corresponding Entity Java Object
@Repository // bean
public interface UserRepository extends JpaRepository<UserEntity, Long> { // 右邊係擺pm key type
  // Built in JPA Method
  // save() connect database -> insert into Users value(...) / similar Map.put -> create or update
  // findAll() select * from users; -> return List<User>
  // findById() -> select * from Users ehere id = ?

  // saveAll(UserEntity) -> Many insert into ... given List<UserEntity>
  // deleteById()

  // Custom JPA Methods
  // select * from Users where name = ?
  List<UserEntity> findByName(String name); // 自己玩

  // select * from Users where name = ? and website = ?
  List<UserEntity> findByNameAndWebsite(String name, String website);

  List<UserEntity> findByNameOrWebsite(String name, String website);

  // JPQL
  // Syntax is similar to SQL
  // Select from Entity Class
  // username -> entity's attribute
  // Support and, or, order by, Inner join, left join, avg(), max(), etc...
  @Query("Select e from UserEntity e where e.username = :username")
  UserEntity findByUserName(@Param("username")String username);

  @Query(value = "Select e from UserEntity e where e.username = :username ORDER BY e.website DESC",
  nativeQuery =  true)
  UserEntity findByUserNameOrderByWebsiteDesc(@Param("username")String username);

  // Native Query (SQL)
  // Disadvantages: Product specific
  // username -> column name (if column not found, SQL Exception)
  @Query(value = "Select * from Users e where e.username = :username",
  nativeQuery =  true)
  UserEntity findByUserName2(@Param("username")String username);

  // For all write operations, use @Modifying
  // delete, insert都係
  @Modifying
  @Query(value = "UPDATE users set user_email = :userEmail Where id = :id",
  nativeQuery = true)
  int updateUserEmail(@Param("userEmail")String userEmail, @Param("id") Long id);
  
}