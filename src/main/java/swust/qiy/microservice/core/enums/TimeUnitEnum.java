package swust.qiy.microservice.core.enums;

import java.time.Duration;

/**
 * @author qiying
 * @create 2019/4/18
 */
public enum TimeUnitEnum {

  /**
   * 毫秒
   */
  MILLIS((byte) 1, "Millis", Duration.ofNanos(1000_000)),

  /**
   * 秒
   */
  SECONDS((byte) 2, "Seconds", Duration.ofSeconds(1)),

  /**
   * 分
   */
  MINUTES((byte) 3, "Minutes", Duration.ofSeconds(60)),

  /**
   * 小数
   */
  HOURS((byte) 4, "Hours", Duration.ofSeconds(3600)),

  /**
   * 天
   */
  DAYS((byte) 5, "Days", Duration.ofSeconds(86400)),

  /**
   * 周
   */
  WEEKS((byte) 6, "Weeks", Duration.ofSeconds(7 * 86400L)),

  /**
   * 月
   */
  MONTHS((byte) 7, "Months", Duration.ofSeconds(31556952L / 12)),

  /**
   * 年
   */
  YEARS((byte) 8, "Years", Duration.ofSeconds(31556952L)),
  ;

  /**
   * 时间类型
   */
  private byte type;
  /**
   * 类型描述
   */
  private String desc;
  /**
   * 类型毫秒数
   */
  private Duration duration;

  TimeUnitEnum(byte type, String desc, Duration duration) {
    this.type = type;
    this.desc = desc;
  }

  public byte getType() {
    return type;
  }

  public void setType(byte type) {
    this.type = type;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Duration getDuration() {
    return duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  public static TimeUnitEnum valueOf(Byte type) {
    if (type == null) {
      return null;
    }
    TimeUnitEnum[] values = values();
    for (TimeUnitEnum timeUnitEnum : values) {
      if (timeUnitEnum.getType() == type) {
        return timeUnitEnum;
      }
    }
    return null;
  }
}
