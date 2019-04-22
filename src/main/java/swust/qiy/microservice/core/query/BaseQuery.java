package swust.qiy.microservice.core.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import swust.qiy.microservice.core.page.PageImpl;

/**
 * @author qiying
 * @create 2019/1/4
 */
public abstract class BaseQuery<T> {

  private long currentPage = 1L;

  private long pageSize = 10L;


  public PageImpl<T> getPage() {
    return new PageImpl<>(currentPage, pageSize);
  }

  public abstract QueryWrapper<T> toQueryWrapper();

  public long getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(long currentPage) {
    this.currentPage = currentPage;
  }

  public long getPageSize() {
    return pageSize;
  }

  public void setPageSize(long pageSize) {
    this.pageSize = pageSize;
  }

}
