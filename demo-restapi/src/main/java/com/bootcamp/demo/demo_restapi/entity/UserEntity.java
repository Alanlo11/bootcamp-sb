package com.bootcamp.demo.demo_restapi.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// JPA
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
@Table(name = "Users") // map to table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment(自動遞增+1)
  private Long id; // Database -> BIGINT 

  private String name; // column
  private String username;
  
  @Column(name = "user_email")
  private String email;
  private String phone;
  private String website;

  // ALL = Remove + persist + merge
  // @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
  // fetch =  FetchType.LAZY)
  // private List<PostEntity> posts;

  // @OneToOne(mappedBy = "user",
  // cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  // private CompanyEntity company;
}