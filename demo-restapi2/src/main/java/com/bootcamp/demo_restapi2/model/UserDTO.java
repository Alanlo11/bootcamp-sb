package com.bootcamp.demo_restapi2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;

  // One to One
  @Getter
  @ToString
  public class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Getter
    @ToString
    public class GeoDTO {
      private String lat;
      private String lng;
    }
  }

  // One to One
  @Getter
  @ToString
  public class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}