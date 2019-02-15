package com.spare.mapper;

import com.spare.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface GradeMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade> selectAllStudent();

    int getMaxGid();
}