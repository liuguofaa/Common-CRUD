package mapper.impl;


import mapper.BMapper;
import org.springframework.stereotype.Component;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:19
 * @description
 */

@Component
public class BMapperImpl implements BMapper {
    @Override
    public String get() {
        return "B";
    }
}
