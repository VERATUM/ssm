package com.spare;

import com.spare.entity.Grade;
import com.spare.mapper.GradeMapper;
import com.spare.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmApplicationTests {
	@Autowired
	DataSource dataSource;
	@Resource
	GradeService gradeService;
	@Resource
	GradeMapper gradeMapper;

	@Test
	public void contextLoads() throws SQLException {
		System.out.println("dataSource.getClass() = " + dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println("connection"+connection.getClientInfo());
		connection.close();
	}

	@Test
	public void test01(){
		List<Grade> grades = gradeService.selectAllStudent();
		grades.forEach(grade -> {
			System.out.println(grade.toString());
		});
	}

	@Test
	public void test02(){
		List<Grade> grades = gradeMapper.selectAllStudent();
		System.out.println(grades);
	}

}

