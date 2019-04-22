package swust.qiy.microservice.core.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;

/**
 * @author qiying
 * @create 2019/3/27
 */
public class HttpClientUtil {

  private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

  private static CloseableHttpClient client = HttpClients.createDefault();

  /**
   * get请求
   */
  public static String doGet(String url) {
    try {
      HttpGet request = new HttpGet(url);
      HttpResponse response = client.execute(request);
      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        return EntityUtils.toString(response.getEntity());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Result doPost(String url, Map<String, String> map) {
    HttpPost httpPost = new HttpPost(url);
    if (map != null) {
      List<BasicNameValuePair> params = map.entrySet().stream()
          .map(entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
          .collect(Collectors.toList());

      UrlEncodedFormEntity formEntity = null;
      try {
        formEntity = new UrlEncodedFormEntity(params, "utf-8");
        formEntity.setContentType(ContentType.APPLICATION_FORM_URLENCODED.toString());
        httpPost.setEntity(formEntity);
      } catch (UnsupportedEncodingException e) {
        return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, "创建formEntity失败: " + e.getMessage());
      }
    }
    CloseableHttpResponse response = null;
    try {
      response = client.execute(httpPost);
      StatusLine status = response.getStatusLine();
      if (HttpStatus.SC_OK != status.getStatusCode()) {
        return ResultUtil.create(ResultCodeEnum.REMOTE_CALL_FAILED, status.getReasonPhrase());
      }
      return ResultUtil.success(EntityUtils.toString(response.getEntity()));
    } catch (IOException e) {
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    } finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          logger.error("close response error: {}", e.getMessage());
        }
      }
    }
  }


  /**
   * post请求（用于请求json格式的参数）
   */
  public static Result doPost(String url, String params) {
    HttpPost httpPost = new HttpPost(url);
    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (StringUtils.isNotBlank(params)) {
      StringEntity entity = new StringEntity(params, "UTF-8");
      httpPost.setEntity(entity);
    }
    CloseableHttpResponse response = null;

    try {
      response = client.execute(httpPost);
      StatusLine status = response.getStatusLine();
      if (HttpStatus.SC_OK != status.getStatusCode()) {
        return ResultUtil.create(ResultCodeEnum.REMOTE_CALL_FAILED, status.getReasonPhrase());
      }
      HttpEntity responseEntity = response.getEntity();
      return ResultUtil.success(EntityUtils.toString(responseEntity));
    } catch (IOException e) {
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    } finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          logger.error("close response error: {}", e.getMessage());
        }
      }
    }
  }

}
