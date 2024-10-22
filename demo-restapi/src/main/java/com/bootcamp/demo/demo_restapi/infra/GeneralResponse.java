package com.bootcamp.demo.demo_restapi.infra;

import java.util.List;
import com.bootcamp.demo.demo_restapi.model.User;

public class GeneralResponse<T> {
  private String code;
  private String message;
  private List<T> data;

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private GeneralResponse(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getData() {
    return this.data;
  }

  @Override
  public String toString(){
    return "GeneralResponse("
    + "code=" + this.code
    + "message=" + this.message
    + "data" + this.data
    + ")";
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private List<T> data;
    

    // set
    public Builder<T> code(String code) {
      this.code = code;
      return this;
    }

    public Builder<T> message(String message) {
      this.message = message;
      return this;
    }

    public Builder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public GeneralResponse<T> build() {
      return new GeneralResponse<>(this);
      // inner class call outer class constructor
    }

    
  }
  public static void main(String[] args) {
    GeneralResponse<User> response = GeneralResponse.<User>builder() // define the Type of static method with Generic
    .code("000000")
    .message("Success")
    .data(List.of(new User()))
    .build();

    System.out.println(response);
  }

}
