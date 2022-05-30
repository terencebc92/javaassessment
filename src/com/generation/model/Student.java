package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;
    private List<Course> courses;


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
        this.courses = new ArrayList<>();
    }

    public boolean enrollToCourse( Course course )
    {
        if (!courses.contains(course)){
            courses.add(course);
            return true;
        }
        return false;
    }

    @Override // edited
    public List<Course> findPassedCourses()
    {
        //Convert list to stream and apply filter method (checking for grades >= minimum pass grade)
        //Then re-convert the stream to a list and return the filtered list.
        return courses.stream().filter(course -> course.getGrade() >= PASS_MIN_GRADE).toList();
    }

    public Course findCourseById( String courseId )
    {
        //Loop through student's course list
        //Use the course.getCode method and check if equivalent to courseID that's passed in
        //If equal, then return that course
        for(Course course: courses) {
            if(course.getCode().equals(courseId)){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        return courses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
