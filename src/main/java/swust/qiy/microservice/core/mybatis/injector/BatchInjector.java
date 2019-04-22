package swust.qiy.microservice.core.mybatis.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDelete;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteBatchByIds;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteById;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByMap;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectBatchByIds;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectById;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectByMap;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectCount;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectList;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectMaps;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectMapsPage;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectObjs;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectOne;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectPage;
import com.baomidou.mybatisplus.extension.injector.methods.LogicUpdate;
import com.baomidou.mybatisplus.extension.injector.methods.LogicUpdateById;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import swust.qiy.microservice.core.mybatis.methods.SaveOrUpdate;
import swust.qiy.microservice.core.mybatis.methods.SaveOrUpdateBatch;

/**
 * @author qiying
 * @create 2019/3/29
 */
public class BatchInjector extends AbstractSqlInjector {

  @Override
  public List<AbstractMethod> getMethodList() {
    return (List) Stream.of(
        new Insert(),
        new LogicDelete(),
        new LogicDeleteByMap(),
        new LogicDeleteById(),
        new LogicDeleteBatchByIds(),
        new LogicUpdate(),
        new LogicUpdateById(),
        new LogicSelectById(),
        new LogicSelectBatchByIds(),
        new LogicSelectByMap(),
        new LogicSelectOne(),
        new LogicSelectCount(),
        new LogicSelectMaps(),
        new LogicSelectMapsPage(),
        new LogicSelectObjs(),
        new LogicSelectList(),
        new LogicSelectPage(),
        new SaveOrUpdateBatch(),
        new SaveOrUpdate()
    ).collect(Collectors.toList());

  }
}
