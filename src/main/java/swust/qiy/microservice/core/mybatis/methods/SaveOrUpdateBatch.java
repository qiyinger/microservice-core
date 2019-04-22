package swust.qiy.microservice.core.mybatis.methods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import java.util.stream.Collectors;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author qiying
 * @create 2019/3/29
 */
public class SaveOrUpdateBatch extends AbstractMethod {

  @Override
  public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass,
      TableInfo tableInfo) {
    KeyGenerator keyGenerator = new NoKeyGenerator();
    ISqlMethod sqlMethod = ISqlMethod.SAVE_OR_UPDATE_BATCH;
    String columnScript =SqlScriptUtils.convertTrim(tableInfo.getFieldList().stream().map(tableFieldInfo -> tableFieldInfo.getColumn()).collect(
        Collectors.joining(",")), "(", ")", (String)null, ",");
    String valueItem = SqlScriptUtils
        .convertTrim(tableInfo.getFieldList().stream().map(tableFieldInfo -> "#{item." + tableFieldInfo.getProperty() + "}").collect(
            Collectors.joining(",")),
            "(", ")", (String) null, ",");
    String valuesScript = SqlScriptUtils
        .convertForeach(valueItem, "coll", (String) null, "item", ",");
    String duplicateKey = tableInfo.getFieldList().stream()
        .map(tableFieldInfo -> tableFieldInfo.getColumn() + " = values(" + tableFieldInfo.getColumn()
            + ")")
        .collect(Collectors.joining(","));
    String keyProperty = null;
    String keyColumn = null;
    if (StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
      if (tableInfo.getIdType() == IdType.AUTO) {
        keyGenerator = new Jdbc3KeyGenerator();
        keyProperty = tableInfo.getKeyProperty();
        keyColumn = tableInfo.getKeyColumn();
      } else if (null != tableInfo.getKeySequence()) {
        keyGenerator = TableInfoHelper
            .genKeyGenerator(tableInfo, this.builderAssistant, sqlMethod.getMethod(),
                this.languageDriver);
        keyProperty = tableInfo.getKeyProperty();
        keyColumn = tableInfo.getKeyColumn();
      }
    }

    String sql = String
        .format(sqlMethod.getSql(), tableInfo.getTableName(), columnScript, valuesScript,
            duplicateKey);
    SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
    return this.addInsertMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource,
        (KeyGenerator) keyGenerator, keyProperty, keyColumn);
  }

  public enum ISqlMethod {

    // 批量更新或插入
    SAVE_OR_UPDATE_BATCH("saveOrUpdateBatch", "批量更新或插入",
        "<script>\nINSERT INTO %s %s VALUES %s ON DUPLICATE KEY UPDATE %s\n</script>"),
    SAVE_OR_UPDATE("saveOrUpdate", "更新或插入", "<script>\nINSERT INTO %s %s VALUES %s ON DUPLICATE KEY UPDATE %s\n</script>");

    private String method;
    private String desc;
    private String sql;

    ISqlMethod(String method, String desc, String sql) {
      this.method = method;
      this.desc = desc;
      this.sql = sql;
    }

    public String getMethod() {
      return this.method;
    }

    public String getDesc() {
      return this.desc;
    }

    public String getSql() {
      return this.sql;
    }
  }


}
