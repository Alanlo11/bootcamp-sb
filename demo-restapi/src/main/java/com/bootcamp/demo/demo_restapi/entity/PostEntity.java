package com.bootcamp.demo.demo_restapi.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Posts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostEntity implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer userId;
  private String title;
  private String body;

  // @JoinColumn(name = "user_id")
  // private UserEntity user;
}