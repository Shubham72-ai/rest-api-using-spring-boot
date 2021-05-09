package com.shubham.restApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shubham.restApi.entity.Course;

// this is service annotation to tell that it is a service
@Service
public class CourseService {
 List<Course> listOfCourse = new ArrayList<>();
  
	
	public CourseService() {
	super();
    listOfCourse.add(new Course(1,"Core Java"));
    listOfCourse.add(new Course(2,"Spring boot"));
    listOfCourse.add(new Course(3,"microService with spring"));
    listOfCourse.add(new Course(4,"Nodejs"));
    listOfCourse.add(new Course(5,"DSA"));
}

    // this service method will all the courses
	public  List<Course> getCouse(){
		return this.listOfCourse;
	}
	
	// this method will return one course with the matching CourseID
	public Course getOneCourse(String cId) {
		var id = Integer.parseInt(cId);
		Course nullCourse = null;
		for(Course course:listOfCourse) {
			if(course.getId() == id) {
				return course;
			}
		}
		return nullCourse;
	}

	// this is for post one course
	public void addOneCourse(Course course) {
		
		listOfCourse.add(course);
	}

	// this is for update one course
	public void updateOneCourse(Course course, String cId) {
/*		{
	    "id": 2,
	    "name": "javaFx"
	}
	this are the request pay load 
	*/
//		System.out.println(course.getName()); -->javaFx
//	    System.out.println(cId); -->2
		var ID = Integer.parseInt(cId);
		for(Course c:listOfCourse) {
			if (c.getId() == ID)
			{
				c.setId(ID);
				c.setName(course.getName());
			}
		}
	}

	public void deleteOneCourse(String cId) {
		var id = Integer.parseInt(cId);
		var i = 0;
		for(Course c:listOfCourse) {
			if(c.getId() == id) {
				listOfCourse.remove(listOfCourse.get(i));
				break;
			}
			i++;
		}
		
	}
	
	
	

}
