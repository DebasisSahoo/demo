package com.example.demo.service;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentModel;


public interface StudentService {
	
	void save(StudentModel student);
	
	public JSONArray getAllStudents();


}
