package com.example.demo.repository.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentModel;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
	
	@Override
	public void Save(StudentModel student) {
		
		JSONObject jo = new JSONObject();
        jo.put("id", student.getId());
        jo.put("firstName", student.getFirstName());
        jo.put("lastName", student.getLastName());
        JSONArray studentList = getAllStudents();
        
        
        
        
        
        
        //JSONArray ja = new JSONArray();
        
        studentList.add(jo);
        
		try (FileWriter file = new FileWriter("StudentData.json")) {
			 
            file.write(studentList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }	
		
		
	}
	
	public JSONArray getAllStudents()
	{
		try {
        	
        	JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader("StudentData.json");
			
			Object obj = jsonParser.parse(reader);
			
			return (JSONArray) obj;
           
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StudentModel findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
