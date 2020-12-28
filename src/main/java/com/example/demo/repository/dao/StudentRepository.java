package com.example.demo.repository.dao;

import java.util.List;

import org.json.simple.JSONArray;

import com.example.demo.model.StudentModel;


public interface StudentRepository {
	
	public void Save(StudentModel student);
	
	public StudentModel findStudentById(int id);
	
	public JSONArray getAllStudents();

}
