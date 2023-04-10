package az.orient.course.service;

import az.orient.course.model.Student;

import java.util.List;

public interface StudentService {


    List<Student> getStudentList() throws Exception;
    void addStudent(Student student) throws Exception;
    Student getStudentById(Long studentId) throws Exception;
    void uptadeStudent(Student student) throws Exception;
    void deleteStudent(Long studentId) throws Exception;
    Integer  studentCount() throws  Exception;
}
