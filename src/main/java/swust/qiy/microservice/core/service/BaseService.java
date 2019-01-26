package swust.qiy.microservice.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.List;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.result.Result;

/**
 * @author qiying
 * @create 2018/11/21
 */
public interface BaseService<T> {

  public Result save(T model);

  public Result deleteById(int id);

  public Result deleteByIds(List<Integer> ids);

  public Result deleteByIds(String ids);

  public Result update(T model);

  public Result<T> findById(int id);

  public Result<List<T>> findByIds(List<Integer> ids);

  public Result<List<T>> findList(Wrapper<T> queryWrapper);

  public Result<List<T>> findList(BaseQuery<T> query);

  public Result<PageImpl<T>> findPage(PageImpl<T> page, Wrapper<T> queryWrapper);

  public Result<PageImpl<T>> findPage(BaseQuery<T> query);

  public Result<Integer> count(Wrapper<T> queryWrapper);

  public Result<Integer> count(BaseQuery<T> query);


}
