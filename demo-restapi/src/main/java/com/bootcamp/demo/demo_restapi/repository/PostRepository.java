package com.bootcamp.demo.demo_restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

  // Repository 天生return Optional

  // 1. JPQL


  // default case, use the name of java Entity class
  // @Query("SELECT '*' from PostEntity where PostEntity.id > 2")
  // List<PostEntity> findPostIdBiggerThanTwo();

  // when you use nativeQuery, use the field name of database
  @Query(value = "SELECT * from posts where posts.id.uuserid > 2",
      nativeQuery = true)
  List<PostEntity> findPostIdBiggerThanTwoVersionTwo();
}
