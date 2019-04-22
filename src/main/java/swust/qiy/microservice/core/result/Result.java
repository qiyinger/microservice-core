package swust.qiy.microservice.core.result;

import swust.qiy.microservice.core.enums.ResultCodeEnum;

/**
 * @author qiying
 * @create 2018/11/9
 */
public class Result<T> {

  private T data;
  private boolean success = true;
  private Integer code;
  private String message;

  public Result<T> data(T data) {
    this.data = data;
    return this;
  }

  public Result success() {
    this.success = true;
    this.code = ResultCodeEnum.OK.getCode();
    return this;
  }

  public Result<T> success(T data) {
    this.data = data;
    this.success = true;
    this.code = ResultCodeEnum.OK.getCode();
    return this;
  }

  public Result fail(ResultCodeEnum codeEnum) {
    return fail(codeEnum, codeEnum.getMsg());
  }

  public Result fail(ResultCodeEnum codeEnum, String msg) {
    this.success = false;
    this.code = codeEnum.getCode();
    this.message = msg;
    return this;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
