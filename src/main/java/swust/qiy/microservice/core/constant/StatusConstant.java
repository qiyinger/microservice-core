package swust.qiy.microservice.core.constant;

/**
 * @author qiying
 * @create 2018/12/7
 */
public class StatusConstant {

  /**
   * 启用
   */
  public final static byte ENABLE = 1;

  /**
   * 未启用
   */
  public final static byte DISABLE = 0;


  /**
   * 已下线
   */
  public final static byte SHUT_DOWN = 2;
  /**
   * 已上线
   */
  public final static byte STARTED = 1;
  /**
   * 待上线
   */
  public final static byte PENDING_STARTED = 0;

  /**
   * 内网
   */
  public final static byte INTRANET = 0;
  /**
   * 内网
   */
  public final static byte EXTRANET = 1;

  /**
   * api
   */
  public final static byte API_TYPE = 1;
  /**
   * 微服务
   */
  public final static byte MICRO_TYPE = 0;

  public final static byte STRATEGY_IP = 0;

  public final static byte STRATEGY_CALL = 1;

  public final static byte CHECK_REFUSE = 0;

  public final static byte CHECK_PENDING = 1;

  public final static byte CHECK_PASS = 2;

  public final static byte ROUTE_MICROSERVICE = 0;

  public final static byte ROUTE_APPLICATION = 1;

  public final static byte ROUTE_SYSTEM = 2;

  // 待发布
  public final static byte PUBLISH_PENDING = 0;
  // 已发布
  public final static byte PUBLISHED = 1;
  // 正在发布
  public final static byte PUBLISH_STARTING = 2;
  // 正在停止
  public final static byte PUBLISH_STOPING = 3;

}
