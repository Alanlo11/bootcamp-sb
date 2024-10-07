package com.bootcamp.demo.demo_restapi.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// JPA
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Hibernate -> @Entity
@Entity // JPA help create table if not exists
@Table(name = "Users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment(自動遞增+1)
  
  private Long id;
  private String name;
  private String username;
  @Column(name = "useremail")
  private String email;
  private String phone;
  private String website;
  private String dummy;
}