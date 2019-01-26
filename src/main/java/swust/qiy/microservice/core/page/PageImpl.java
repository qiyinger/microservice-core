package swust.qiy.microservice.core.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collections;
import java.util.List;

/**
 * @author qiying
 * @create 2019/1/23
 */
@JsonIgnoreProperties({PageImpl.FIELD_SIZE,PageImpl.FIELD_CURRENT
    ,PageImpl.FIELD_TOTAL,PageImpl.FIELD_PAGES})
public class PageImpl<T> implements IPage<T> {

  static final String FIELD_SIZE = "size";
  static final String FIELD_TOTAL = "total";
  static final String FIELD_CURRENT = "current";
  static final String FIELD_PAGES = "pages";


  private List<T> records;
  private long total;
  private long size;
  private long current;
  private boolean isSearchCount;

  public PageImpl() {
    this.records = Collections.emptyList();
    this.total = 0L;
    this.size = 10L;
    this.current = 1L;
    this.isSearchCount = true;
  }

  public PageImpl(long current, long size) {
    this(current, size, 0L);
  }

  public PageImpl(long current, long size, long total) {
    this(current, size, total, true);
  }

  public PageImpl(long current, long size, boolean isSearchCount) {
    this(current, size, 0L, isSearchCount);
  }

  public PageImpl(long current, long size, long total, boolean isSearchCount) {
    this.records = Collections.emptyList();
    this.current = 1L;
    this.size = 20L;
    this.total = 0;
    if (current > 1L) {
      this.current = current;
    }
    if (size > 0) {
      this.size = size;
    }
    if (total > 0) {
      this.total = total;
    }
    this.isSearchCount = isSearchCount;
  }

  @Override
  public List<T> getRecords() {
    return this.records;
  }

  @Override
  public PageImpl<T> setRecords(List<T> records) {
    this.records = records;
    return this;
  }

  @Override
  public long getTotal() {
    return this.total;
  }

  @Override
  public PageImpl<T> setTotal(long total) {
    this.total = total;
    return this;
  }

  @Override
  public long getSize() {
    return this.size;
  }

  @Override
  public PageImpl<T> setSize(long size) {
    this.size = size;
    return this;
  }

  @Override
  public long getCurrent() {
    return this.current;
  }

  @Override
  public PageImpl<T> setCurrent(long current) {
    this.current = current;
    return this;
  }

  @Override
  public boolean isSearchCount() {
    return this.total >= 0L && this.isSearchCount;
  }

  public PageImpl<T> setSearchCount(boolean isSearchCount) {
    this.isSearchCount = isSearchCount;
    return this;
  }

  public ResultPage getPage() {
    return new ResultPage(current, size, total, getPages());
  }

}
