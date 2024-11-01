package com.bootcamp.bc_forum.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class UserDTO {
  private Long id;
  private String name;

  @Column(name = "user_name")
  private String username;

  private String email;
  private String phone;
  private String website;

  private AddressDTO address;
  private CommentDTO comment;


  public static class AddressDTO {
    private Long id;
    private String street;
    private String sute;
  }

  public static class CommentDTO {

  }

  public static class GeoDTO {

  }
}
