package service.base;

import java.io.Serializable;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:23
 * @description
 */
public interface IService<T> {

    int insert(T entity);

    int deleteById(Serializable id);

    T selectById(Serializable id);

    int updateById(T entity);
}
