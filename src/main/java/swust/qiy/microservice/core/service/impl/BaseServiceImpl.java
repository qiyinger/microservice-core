package swust.qiy.microservice.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import swust.qiy.microservice.core.dao.BaseDao;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.core.util.StringUtil;

/**
 * @author qiying
 * @create 2018/11/21
 */
public class BaseServiceImpl<T> implements BaseService<T> {

  @Autowired
  protected BaseDao<T> baseDao;

  @Override
  public Result<Integer> save(T model) {
    return ResultUtil.success(baseDao.insert(model));
  }

  @Override
  public Result<Integer> deleteById(int id) {
    return ResultUtil.success(baseDao.deleteById(id));
  }

  @Override
  public Result<Integer> deleteByIds(List<Integer> ids) {
    return ResultUtil.success(baseDao.deleteBatchIds(ids));
  }

  @Override
  public Result<Integer> deleteByIds(String ids) {
    return ResultUtil.success(baseDao.deleteBatchIds(StringUtil.string2list(ids)));
  }

  @Override
  public Result<Integer> update(T model) {
    return ResultUtil.success(baseDao.updateById(model));
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

  @Override
  public BaseDao<T> getBaseMapper() {
    return this.baseDao;
  }

  @Override
  @Transactional
  public Result<Integer> saveOrUpdateBatch(List<T> list) {
    return saveOrUpdateBatch(list, 50);
  }

  @Override
  public Result<Integer> saveOrUpdateBatch(List<T> list, int num) {
    List<T> temp = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      temp.add(list.get(i));
      if (i != 0 && i % num == 0) {
        sum += baseDao.saveOrUpdateBatch(temp);
        temp.clear();
      }
    }
    return ResultUtil.success(sum);
  }

  @Override
  public Result checkId(BaseDao baseDao, Integer id) {
    Object obj = baseDao.selectById(id);
    ResultAsset.notNull(obj, ResultCodeEnum.RECORD_NOT_EXIST, "Id不存在");
    return ResultUtil.success(obj);
  }

  @Override
  public Result checkId(Integer id) {
    return checkId(getBaseMapper(), id);
  }
}

