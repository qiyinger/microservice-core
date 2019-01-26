package swust.qiy.microservice.core.util;

import com.google.common.base.CaseFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author qiying
 * @create 2018/11/21
 */
public class StringUtil {

  public static List<String> string2list(String str) {
    return string2list(str, ",");
  }

  public static List<String> string2list(String str, String split) {
    List<String> list = new ArrayList<>();
    if (StringUtils.isEmpty(str)) {
      return list;
    }
    String[] arr = str.split(split);
    list = Arrays.stream(arr)
        .filter(StringUtils::isNotEmpty)
        .collect(Collectors.toList());
    return list;
  }

  public static List<Integer> string2IntList(String str) {
    List<String> strList = string2list(str);
    List<Integer> list = new ArrayList<>();
    if (CollectionUtils.isEmpty(strList)) {
      return list;
    }
    list = strList.stream()
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    return list;
  }

  /**
   * 驼峰命名转下划线
   */
  public static String camel2lowUndercore(String str) {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
  }

  /**
   * 驼峰命名转下滑线(大写)
   */
  public static String camel2upUndercore(String str) {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, str);
  }

  /**
   * 下划线转驼峰(小写开头)
   */
  public static String undercore2camel(String str) {
    return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
  }

  /**
   * 大写转小写
   */
  public static String up2lowCamel(String str) {
    return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, str);
  }

  /**
   * 小写转大写
   */
  public static String low2upCamel(String str) {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, str);
  }


}
