package service.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:31
 * @description
 */

public class BaseService<T> implements IService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public int insert(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int deleteById(Serializable id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int updateById(T entity) {
        return baseMapper.updateById(entity);
    }
}
