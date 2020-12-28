package com.example.demo.service;

import java.io.FileWriter;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.dao.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	public StudentRepository studentRepository;
	
	public void save(StudentModel student) {
		
		studentRepository.Save(student);
	}
	
	public JSONArray getAllStudents()
	{
		return studentRepository.getAllStudents();
	}


}
