package mapper.impl;


import mapper.AMapper;
import org.springframework.stereotype.Component;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:19
 * @description
 */

@Component
public class AMapperImpl implements AMapper {
    @Override
    public String get() {
        return "A";
    }
}
