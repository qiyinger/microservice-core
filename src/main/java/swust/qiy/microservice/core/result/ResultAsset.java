package swust.qiy.microservice.core.result;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.exception.ResultIllegalException;

/**
 * @author qiying
 * @create 2019/5/16
 */
public class ResultAsset {


  public static void isTrue(boolean expression, ResultCodeEnum codeEnum, String msg) {
    isTrue(expression, codeEnum.getCode(), msg);
  }

  public static void isTrue(boolean expression, ResultCodeEnum codeEnum) {
    isTrue(expression, codeEnum.getCode(), codeEnum.getMsg());
  }
  

  public static void isTrue(boolean expression,Integer code, String message) {
    if (!expression) {
      throw new ResultIllegalException(code,message);
    }
  }

  public static void isNull(@Nullable Object object, ResultCodeEnum codeEnum, String msg) {
    isNull(object, codeEnum.getCode(), msg);
  }

  public static void isNull(@Nullable Object object, ResultCodeEnum codeEnum) {
    isNull(object, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void isNull(@Nullable Object object, Integer code, String message) {
    if (object != null) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void notNull(@Nullable Object object, ResultCodeEnum codeEnum, String msg) {
    notNull(object, codeEnum.getCode(), msg);
  }

  public static void notNull(@Nullable Object object, ResultCodeEnum codeEnum) {
    notNull(object, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void notNull(@Nullable Object object, Integer code, String message) {
    if (object == null) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void hasLength(@Nullable String text, ResultCodeEnum codeEnum, String msg) {
    hasLength(text, codeEnum.getCode(), msg);
  }

  public static void hasLength(@Nullable String text, ResultCodeEnum codeEnum) {
    hasLength(text, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void hasLength(@Nullable String text, Integer code, String message) {
    if (!StringUtils.hasLength(text)) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void hasText(@Nullable String text, ResultCodeEnum codeEnum, String msg) {
    hasText(text, codeEnum.getCode(), msg);
  }

  public static void hasText(@Nullable String text, ResultCodeEnum codeEnum) {
    hasText(text, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void hasText(@Nullable String text, Integer code, String message) {
    if (!StringUtils.hasText(text)) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void notEmpty(Object[] array, ResultCodeEnum codeEnum, String msg) {
    notEmpty(array, codeEnum.getCode(), msg);
  }

  public static void notEmpty(Object[] array, ResultCodeEnum codeEnum) {
    notEmpty(array, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void notEmpty(Object[] array, Integer code, String message) {
    if (ObjectUtils.isEmpty(array)) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void noNullElements(@Nullable Object[] array, ResultCodeEnum codeEnum, String msg) {
    noNullElements(array, codeEnum.getCode(), msg);
  }

  public static void noNullElements(@Nullable Object[] array, ResultCodeEnum codeEnum) {
    noNullElements(array, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void noNullElements(@Nullable Object[] array, Integer code, String message) {
    if (array != null) {
      Object[] var2 = array;
      int var3 = array.length;

      for (int var4 = 0; var4 < var3; ++var4) {
        Object element = var2[var4];
        if (element == null) {
          throw new ResultIllegalException(code, message);
        }
      }
    }
  }

  public static void notEmpty(@Nullable Collection<?> collection, ResultCodeEnum codeEnum, String msg) {
    notEmpty(collection, codeEnum.getCode(), msg);
  }

  public static void notEmpty(@Nullable Collection<?> collection, ResultCodeEnum codeEnum) {
    notEmpty(collection, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void notEmpty(Collection<?> collection, Integer code, String message) {
    if (CollectionUtils.isEmpty(collection)) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void notEmpty(Map<?, ?> map, ResultCodeEnum codeEnum, String msg) {
    notEmpty(map, codeEnum.getCode(), msg);
  }

  public static void notEmpty(Map<?, ?> map, ResultCodeEnum codeEnum) {
    notEmpty(map, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void notEmpty(Map<?, ?> map, Integer code, String message) {
    if (CollectionUtils.isEmpty(map)) {
      throw new ResultIllegalException(code, message);
    }
  }

  public static void notEmpty(String text, ResultCodeEnum codeEnum, String msg) {
    notEmpty(text, codeEnum.getCode(), msg);
  }

  public static void notEmpty(String text, ResultCodeEnum codeEnum) {
    notEmpty(text, codeEnum.getCode(), codeEnum.getMsg());
  }

  public static void notEmpty(String  text, Integer code, String message) {
    if (StringUtils.isEmpty(text)) {
      throw new ResultIllegalException(code, message);
    }
  }

}
