package mapper.impl;


import org.springframework.stereotype.Component;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:19
 * @description
 */

@Component
public class CMapperImpl implements mapper.CMapper {
    @Override
    public String get() {
        return "C";
    }
}
