package com.spare.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spare.entity.Grade;
import com.spare.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GradeController {
	@Resource
	GradeService gradeService;
	// 同步方式
	// 查询所有
	@GetMapping("/grades/")
	public String showAllGrade(Model model){
		int rows = 6;
		PageHelper.startPage(1,rows);
		List<Grade> gradeList = gradeService.selectAllStudent();
		PageInfo<Grade> pageInfo = new PageInfo<>(gradeList);
		model.addAttribute("grades",pageInfo);
		return "grade/index";
	}

	@GetMapping("/grades/{pageNum}")
	public String showAllGrade(@PathVariable("pageNum") Integer pageNum,Model model){
		int rows = 6;
		PageHelper.startPage((pageNum==null?1:pageNum),rows);
		List<Grade> gradeList = gradeService.selectAllStudent();
		PageInfo<Grade> pageInfo = new PageInfo<>(gradeList);
		model.addAttribute("grades",pageInfo);
		return "grade/index";
	}

	// 添加单条
	// 1.页面跳转
	@GetMapping("/grade")
	public String selectGrade(){
		return "grade/add";
	}
	// 2.添加
	@PostMapping("/grade")
	public String insertGrade(Grade grade){
		int gid = gradeService.getMaxGid();
		grade.setGid(gid+1);
		gradeService.insert(grade);
		return "redirect:/grades/";
	}

	// 删除单条
	@DeleteMapping("/grade/{gid}")
	public String deleteGrade(@PathVariable("gid") Integer gid){
		gradeService.deleteByPrimaryKey(gid);
		return "redirect:/grades/";
	}

	// 修改单条
	@GetMapping("/grade/{gid}")
	public String toUpdateGrade(@PathVariable("gid") Integer gid,Model model){
		Grade grade = gradeService.selectByPrimaryKey(gid);
		model.addAttribute("grade",grade);
		return "grade/add";
	}

	@PutMapping("/grade")
	public String updateGrade(Grade grade){
		gradeService.updateByPrimaryKey(grade);
		return "redirect:/grades/";
	}
}
