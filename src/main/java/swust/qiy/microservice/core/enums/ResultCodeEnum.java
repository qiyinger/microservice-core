package swust.qiy.microservice.core.enums;

/**
 * @author qiying
 * @create 2018/11/21
 */
public enum ResultCodeEnum {
  // 成功
  OK(0, "ok"),

  NO_LOGIN(1001, "用户未登录"),
  NO_AUTH(1002, "用户无权限"),

  NULL_POINT_EXECPTION(2001, "空指针"),
  DB_EXCEPTION(2001, "数据库异常"),
  SYSTEM_ERROR(2003, "系统错误"),

  PARAM_ERROR(3001, "参数错误"),
  INVALID_OPERATION(3002, "非法操作"),
  NONE_RECORD(3003, "没有记录"),
  RECORD_EXIST(3004, "记录已存在"),
  RECORD_NOT_EXIST(3005, "记录不存在"),
  DISABLE_DELETE(3006, "存在子模块, 无法删除"),

  ;

  ResultCodeEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private Integer code;
  private String msg;

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
