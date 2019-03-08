package swust.qiy.microservice.core.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author qiying
 * @create 2019/1/22
 */
public class CommonUtil {

  public static boolean isEmpty(String val) {
    return StringUtils.isEmpty(val);
  }

  public static boolean isEmpty(Object val) {
    return ObjectUtils.isEmpty(val);
  }

}
