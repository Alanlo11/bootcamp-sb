package com.bootcamp.demo.demo_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// This class is designed for Serialization (JSON -> Java Object) ONLY.
// So, only getter is required
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Integer id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  // One to One
  @Getter
  @ToString
  public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @ToString
    public class Geo {
      private String lat;
      private String lng;
    }
  }

  // One to One
  @Getter
  @ToString
  public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  // public static UserEntity convert(User user){
  //   return new UserEntity(user.getId(),user.getName(),user.getUsername(),user.getEmail(),user.getPhone(),user.getWebsite());
  // }
}