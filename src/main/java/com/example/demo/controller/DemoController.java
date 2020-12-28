package com.example.demo.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;
import com.example.demo.model.StudentModel;

@RestController
public class DemoController {
	
	//public static List<StudentModel> studentsList = new ArrayList<>();
	
	@Autowired
	public StudentService studentService;
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "<h1>Hello</h1>";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/students")
	public List<StudentModel> getStudentDetails() {
		
		List<StudentModel> students = new ArrayList<StudentModel>();
		StudentModel sm1 = new StudentModel(1, "sarvana", "velus");
		StudentModel sm2 = new StudentModel(2, "tapan", "sirol");
		
		students.add(sm1);
		students.add(sm2);
		return students;
		
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public void addStudent(@RequestBody StudentModel student) {

		
		studentService.save(student);
		
	}
	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	public JSONArray addStudent() {

		
		return studentService.getAllStudents();
		
	}
	
	
	

}
