package com.bootcamp.demo.demo_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  
}
