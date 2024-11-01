package com.bootcamp.demo_restapi2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Hibernate -> @Entity
@Entity // JPA help create table if not exists
@Table(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity implements Serializable{
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
  private Long id;
  private String name; // column
  private String username;
  @Column(name = "user_email")
  private String email;
  private String phone;
  private String website;

  // ALL = REMOVE + PERSIST + MERGE
  @Builder.Default
  @OneToMany(mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      fetch = FetchType.LAZY)
  private List<PostEntity> posts = new ArrayList<>();

  @OneToOne(mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      fetch = FetchType.LAZY)
  private CompanyEntity company;
}