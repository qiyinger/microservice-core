package swust.qiy.microservice.core.exception;

/**
 * @author qiying
 * @create 2018/11/29
 */
public class OperationIllegalException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public OperationIllegalException() {
  }

  public OperationIllegalException(String message) {
    super(message);
  }
}
