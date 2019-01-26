package swust.qiy.microservice.core.page;

/**
 * @author qiying
 * @create 2019/1/25
 */
public class ResultPage {

  private long currentPage;

  private long pageSize;

  private long total;

  private long pages;

  public ResultPage(long currentPage, long pageSize, long total,long pages) {
    this.currentPage = currentPage;
    this.pageSize = pageSize;
    this.total = total;
    this.pages = pages;
  }

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

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public long getPages() {
    return pages;
  }

  public void setPages(long pages) {
    this.pages = pages;
  }
}
