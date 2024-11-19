package com.bootcamp.demo_restapi2.util;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.demo_restapi2.model.UserDTO;

public class GeneralResponse<T> {
  private String code;
  private String message;
  private List<T> data;// List<T>

  public static <U> Builder<U> builder() {
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
  public String toString() {
    return "GeneralResponse(" //
        + "code=" + this.code //
        + ", message=" + this.message //
        + ", data=" + this.data //
        + ")";
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private List<T> data;

    public Builder<T> status(SysCode sysCode) {
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      if (sysCode == SysCode.FAIL) {
        this.data = new ArrayList<>();
      }
      return this;
    }

    public Builder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public GeneralResponse<T> build() {
      if (this.code == null || this.message == null)
        throw new IllegalArgumentException("Missing Code and Message.");
      return new GeneralResponse<>(this);
      // inner class call outer class' constructor
    }
  }

  public static void main(String[] args) {
    // define the type of static method with generic
    GeneralResponse<UserDTO> response =
        GeneralResponse.<UserDTO>builder().status(SysCode.FAIL)
            // .data(null)
            .build();

    System.out.println(response);
  }
}
