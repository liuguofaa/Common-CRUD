package service.base;

import mapper.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:31
 * @description
 */

public class BaseService<T> implements IService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public String get() {
        return baseMapper.get();
    }
}
