package swust.qiy.microservice.core.exception;

/**
 * @author qiying
 * @create 2019/5/16
 */
public class ResultIllegalException extends RuntimeException {

  private Integer code;
  private String message;

  public ResultIllegalException(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
