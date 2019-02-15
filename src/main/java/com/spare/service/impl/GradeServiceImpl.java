package com.spare.service.impl;

import com.spare.entity.Grade;
import com.spare.mapper.GradeMapper;
import com.spare.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class GradeServiceImpl implements GradeService {
	@Resource
	GradeMapper gradeMapper;
	@Override
	public int deleteByPrimaryKey(Integer gid) {
		return gradeMapper.deleteByPrimaryKey(gid);
	}

	@Override
	public int insert(Grade record) {
		return gradeMapper.insert(record);
	}

	@Override
	public Grade selectByPrimaryKey(Integer gid) {
		return gradeMapper.selectByPrimaryKey(gid);
	}

	@Override
	public int updateByPrimaryKey(Grade record) {
		return gradeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Grade> selectAllStudent() {
		return gradeMapper.selectAllStudent();
	}

	@Override
	public int getMaxGid() {
		return gradeMapper.getMaxGid();
	}
}
