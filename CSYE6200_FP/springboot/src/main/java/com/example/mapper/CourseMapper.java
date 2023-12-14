package com.example.mapper;

import com.example.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;
public interface CourseMapper {
    @Select("select * from course where number like concat('%',#{number}, '%') " +
            "and subject like concat('%',#{subject}, '%') " +
            "and campus like concat('%',#{campus}, '%') order by id desc")
    List<Course> selectAll(String number, String subject, String campus);

    @Insert("insert into course (title, number, instructor, section, subject, campus, hours, description, location, timetable)" +
            "values (#{title}, #{number}, #{instructor}, #{section}, #{subject}, #{campus}, #{hours}, #{description}, #{location}, #{timetable})")
    void insert(Course course);
}