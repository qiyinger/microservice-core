package swust.qiy.microservice.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Collection;
import org.apache.ibatis.annotations.Param;

/**
 * @author qiying
 * @create 2019/3/29
 */
public interface BaseDao<T> extends BaseMapper<T> {

  /**
   * 批量插入或更新
   */
  int saveOrUpdateBatch(@Param("coll") Collection<T> list);

  int saveOrUpdate(T entity);


}
