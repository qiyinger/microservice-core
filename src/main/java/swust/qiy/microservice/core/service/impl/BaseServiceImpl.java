package swust.qiy.microservice.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.core.util.StringUtil;

/**
 * @author qiying
 * @create 2018/11/21
 */
public class BaseServiceImpl<T> implements BaseService<T> {

  @Autowired
  protected BaseMapper<T> baseDao;

  @Override
  public Result save(T model) {
    baseDao.insert(model);
    return ResultUtil.success();
  }

  @Override
  public Result deleteById(int id) {
    baseDao.deleteById(id);
    return ResultUtil.success();
  }

  @Override
  public Result deleteByIds(List<Integer> ids) {
    baseDao.deleteBatchIds(ids);
    return ResultUtil.success();
  }

  @Override
  public Result deleteByIds(String ids) {
    baseDao.deleteBatchIds(StringUtil.string2list(ids));
    return ResultUtil.success();
  }

  @Override
  public Result update(T model) {
    baseDao.updateById(model);
    return ResultUtil.success();
  }

  @Override
  public Result<T> findById(int id) {
    return ResultUtil.success(baseDao.selectById(id));
  }

  @Override
  public Result<List<T>> findByIds(List<Integer> ids) {
    return ResultUtil.success(baseDao.selectBatchIds(ids));
  }

  @Override
  public Result<List<T>> findList(Wrapper<T> queryWrapper) {
    return ResultUtil.success(baseDao.selectList(queryWrapper));
  }

  @Override
  public Result<List<T>> findList(BaseQuery<T> query) {
    return ResultUtil.success(baseDao.selectList(query.toQueryWrapper()));
  }

  @Override
  public Result<PageImpl<T>> findPage(PageImpl<T> page, Wrapper<T> queryWrapper) {
    baseDao.selectPage(page, queryWrapper);
    return ResultUtil.success(page);
  }

  @Override
  public Result<PageImpl<T>> findPage(BaseQuery<T> query) {
    return findPage(query.getPage(), query.toQueryWrapper());
  }

  @Override
  public Result<Integer> count(Wrapper<T> queryWrapper) {
    return ResultUtil.success(baseDao.selectCount(queryWrapper));
  }

  @Override
  public Result<Integer> count(BaseQuery<T> query) {
    return ResultUtil.success(baseDao.selectCount(query.toQueryWrapper()));
  }
}

