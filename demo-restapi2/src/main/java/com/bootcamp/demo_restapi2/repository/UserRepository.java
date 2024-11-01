package com.bootcamp.demo_restapi2.repository;

import org.springframework.stereotype.Repository;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
// ! Built in JPA Methods
  // save() -> insert into Users value (...) / similar Map.put -> create or
  // update
  // findAll() -> select * from Users; -> return List<User>
  // findById() -> select * from Users where id = ?

  // saveAll(userEntities) -> Many insert into ... given List<UserEntity>
  // deleteById()

  // ! Custom JPA Methods
  // select * from Users where name = ?
  List<UserEntity> findByName(String name); //

  // select * from Users where name = ? and website = ?
  List<UserEntity> findByNameAndWebsite(String name, String website);

  // select * from Users where name = ? or website = ?
  List<UserEntity> findByNameOrWebsite(String name, String website);

  // ! JPQL
  // Syntax is similar to SQL
  // select from Entity Class
  // username -> entity's attribute
  // Support and, or, order by, Inner join, left join, avg(), max() etc ...
  @Query("SELECT e FROM UserEntity e WHERE e.username = :username")
  UserEntity findByUsername(@Param("username") String username);

  @Query(value = "SELECT e FROM UserEntity e WHERE e.username = :username ORDER BY e.website DESC")
  UserEntity findByUsernameOrderByWebsiteDesc(@Param("username") String username);

  // ! Native Query (SQL)
  // Disadvantages: Product specific
  // username -> column name (if column not found, SQL Exception)
  @Query(value = "SELECT * FROM Users e WHERE e.username = :username",
      nativeQuery = true)
  UserEntity findByUsername2(@Param("username") String username);

  // ! For all write operations, use @Modifying
  @Modifying
  @Query(value = "UPDATE Users SET user_email = :userEmail WHERE id = :id", nativeQuery = true)
  int updateUserEmail(@Param("userEmail") String userEmail, @Param("id") Long id);

}