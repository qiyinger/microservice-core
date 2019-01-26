package swust.qiy.microservice.core.result;

import swust.qiy.microservice.core.enums.ResultCodeEnum;

/**
 * @author qiying
 * @create 2019/1/23
 */
public class ResultUtil {

  public static <T> Result success() {
    return new Result<>().success();
  }

  public static <T> Result<T> success(T data) {
    return new Result<T>().success(data);
  }

  public static Result create(ResultCodeEnum resultCodeEnum, String msg) {
    return new Result().fail(resultCodeEnum, msg);
  }

  public static Result create(ResultCodeEnum resultCodeEnum) {
    return new Result().fail(resultCodeEnum);
  }


}
