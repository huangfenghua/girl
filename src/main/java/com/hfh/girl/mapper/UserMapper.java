package com.hfh.girl.mapper;

import com.hfh.girl.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.UUID;

@Repository
public interface UserMapper {
    @Select("SELECT * FROM Person WHERE id = #{id}")
    Person selectUser(int id);

    @Insert("INSERT INTO Person(id,name, age) VALUES(#{id},#{name}, #{age})")
    int insertUser(@Param(value = "id") int id,@Param(value = "name") String name,@Param(value = "age") int age);

    @Select("delete from  person WHERE id= #{id}")
    int DeleteUser(int id);

    @Update("update person set name=#{name}, age=#{age} where id=#{id}")
    int UpdateUser(@Param(value = "id") int id,@Param(value = "name") String name,@Param(value = "age") int age);
    @Select("select * from Person WHERE name = #{name} and age=#{age}")
    Person login(@Param("name") String name,@Param("age") int age);
}