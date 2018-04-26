package com.example.demo.mapper;

import com.example.demo.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yinxf on 2018/4/18.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM Person WHERE id = #{id}")
    Person selectUser(int id);
}
