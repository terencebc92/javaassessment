package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        // Check if students HashMap contains students, if not, add student
        // If student not in HashMap, put student in HashMap
        // Otherwise, say "Student already subscribed"
        if (!students.containsKey(student.getId())){
            students.put(student.getId(), student);
            System.out.println( "Student Successfully Registered!" );
        } else {
            System.out.println("Student with that ID is already subscribed!");
        }

    }

    public Student findStudent( String studentId )
    {
        //In the students HashMap, get the student value using studentID and return the student
        return students.get(studentId);
    }

    public boolean showSummary()
    {
        if(students.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean enrollToCourse( String studentId, Course course ) // changed to boolean so that Main can print "Student is already registered to course" if course is already registered
    {
        // Use findStudent method to get the student object
        // Call the student's enrollToCourse method and pass in course
        if (this.findStudent(studentId).enrollToCourse(course)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String summary = "";
        for(Student student: students.values()){
            summary += student + "\n";
            summary += "Enrolled Courses:\n";
            for (Course course: student.getEnrolledCourses()) {
                summary += course;
            }
        }
        return summary;

    }

}
