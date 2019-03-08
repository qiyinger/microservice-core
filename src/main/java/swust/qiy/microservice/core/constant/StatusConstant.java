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
  public final static byte API_TYPE = 0;
  /**
   * 微服务
   */
  public final static byte MICRO_TYPE = 1;

  public final static byte STRATEGY_IP = 0;

  public final static byte STRATEGY_CALL = 1;

}
