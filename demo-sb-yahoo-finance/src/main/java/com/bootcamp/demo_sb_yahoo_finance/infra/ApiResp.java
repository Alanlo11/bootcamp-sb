package com.bootcamp.demo_sb_yahoo_finance.infra;

public class ApiResp<T> {
  private String code;
  private String message;
  private T data;

  private String getCode() {
    return this.code;
  }

  private String getMessage() {
    return this.message;
  }

  private T getDate() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private ApiResp(Builder<T> builder) {
    this.code = builder.code;
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private T data;

    public Builder<T> ok() {
      this.code = RespCode.OK.getCode();
      this.message = RespCode.OK.getMessage();
      return this;
    }

    public Builder<T> fail(Exception e) {
      this.code = RespCode.FAIL.getCode();
      this.message = e.getMessage();
      return this;
    }

    public Builder<T> data(T data){
      this.data = data;
      return this;
    }

    public ApiResp<T> build(){
      if(this.code == null || this.message == null) throw new IllegalArgumentException("Api Error");
      return new ApiResp<>(this);
    }

  }
}
