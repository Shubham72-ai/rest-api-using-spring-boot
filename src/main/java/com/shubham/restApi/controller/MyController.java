package com.shubham.restApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.restApi.entity.Course;
import com.shubham.restApi.service.CourseService;

// this is our controllers
@RestController
public class MyController {
	
	@Autowired
	CourseService courseServive;

	@GetMapping("/")
	String Home() {
		return "this is Home";
	}
	
	// this will return all the courses that is there
	@GetMapping("/courses")
	List<Course> getCourses(){
		
		return courseServive.getCouse() ;
	}
	
	@GetMapping("/courses/{cId}")
	Course getOneCourse(@PathVariable String cId)
	{
	  return courseServive.getOneCourse(cId);
	}
	
	// in this method we are posting one course and then sending all 
	/*
	 * another way to write this as
	 * ReqestMapping(path="/course", method=RequestMethod.GET) or anything you want
	 */
	@PostMapping("/courses")
	List<Course> getAllWithNewOne(@RequestBody Course course){
		courseServive.addOneCourse(course);
		return courseServive.getCouse();
	}
	
	
	// this is for handling the put request
	@PutMapping("/courses/{cId}")
	List<Course> updateOneCourse(@RequestBody Course course, @PathVariable String cId) {
		courseServive.updateOneCourse(course,cId);
		return courseServive.getCouse();
	}
	
	
	// this is for handling the delete request 
	@DeleteMapping("/courses/{cId}")
	List<Course> deleteOneCourse(@PathVariable String cId){
		courseServive.deleteOneCourse(cId);
		return courseServive.getCouse();
		
	}
}