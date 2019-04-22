package swust.qiy.microservice.core.eureka;

import lombok.Data;

/**
 * @author qiying
 * @create 2019/3/22
 */
@Data
public class InstanceInfo {

  /**
   * 实例id
   */
  private String instanceId;

  /**
   * 主机名
   */
  private String hostName;

  /**
   * 服务名
   */
  private String serviceName;

  /**
   * ip地址
   */
  private String ipAddr;

  /**
   * 启用状态
   */
  private String status;

  /**
   * 服务端口
   */
  private Integer port;

  /**
   * 端口状态
   */
  private boolean portEnable;

  /**
   * 服务主页
   */
  private String homePageUrl;

  /**
   * 最后操作时间
   */
  private Long lastUpdatedTimestamp;

  /**
   * 不知道, 英文不好
   */
  private Long lastDirtyTimestamp;

  /**
   * 操作类型
   */
  private String actionType;
}
