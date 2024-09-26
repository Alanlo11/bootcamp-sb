package com.bootcamp.demo.demo_sb_calculator.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data
@ToString
@EqualsAndHashCode
@Getter
// @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private int id;
  private double price;
  private List<String> strings; // dummy data
}