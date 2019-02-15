package com.spare.service;

import com.spare.entity.Grade;

import java.util.List;

public interface GradeService {
	int deleteByPrimaryKey(Integer gid);

	int insert(Grade record);

	Grade selectByPrimaryKey(Integer gid);

	int updateByPrimaryKey(Grade record);

	List<Grade> selectAllStudent();

	int getMaxGid();
}
