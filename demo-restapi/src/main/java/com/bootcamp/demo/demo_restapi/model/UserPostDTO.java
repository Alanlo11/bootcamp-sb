package com.bootcamp.demo.demo_restapi.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDTO {
  private Long userid;
  private String username;
  private String useremail;
  private List<PostDTO> postDTO;
}