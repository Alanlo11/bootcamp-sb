package com.bootcamp.demo.demo_sb_calculator.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// Spring -> Serialization(Requires Getter): Java Object -> JSON Pain Text

// @Data
@ToString
@EqualsAndHashCode
@Getter
// @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Bag {
  @JsonProperty(value = "bookList")
  private List<Book> books;
  private Color color;

  public static enum Color{
    RED,YELLOW,BLUE,;
  }
}