package cn.yong.center.practice.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充配置
 *
 * @author dengweiyi
 * @date 2019-12-16
 */
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    /**
     * mybatis-plus公共字段自动填充，https://baomidou.oschina.io/mybatis-plus-doc/#/auto-fill
     * <p>
     * TODO 后续需要删除创建者和修改者的空字符串，改为正确的创建者和修改者
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createdTime", new Date(), metaObject);
        setFieldValByName("updatedTime", new Date(), metaObject);
        setFieldValByName("createdBy", "", metaObject);
        setFieldValByName("updatedBy", "", metaObject);
        setFieldValByName("dr", 0L, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updatedTime", new Date(), metaObject);
        setFieldValByName("updatedBy", "", metaObject);
    }
}