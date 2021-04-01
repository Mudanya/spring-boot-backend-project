package com.nexobentola.FullSPring.student;

import com.nexobentola.FullSPring.EmailValidator;
import com.nexobentola.FullSPring.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;
    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }
    void addNewStudent(Student student) {
       addNewStudent(null, student);
    }

    void addNewStudent(UUID studentId, Student student) {
        UUID newStudent = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

        if(!emailValidator.test(student.getEmail())){
            throw new ApiRequestException(student.getEmail() + " is invalid email!");
        }

        if(studentDataAccessService.isEmailTaken(student.getEmail())){
            throw new ApiRequestException(student.getEmail()+" exists");
        }

        studentDataAccessService.insertStudent(newStudent, student);
    }

    List< Student > getAllStudents() {
        return studentDataAccessService.selectAllStudents();
    }

    public List<StudentCourse> getAllCoursesForStudents(UUID studentId) {
        return studentDataAccessService.selectAllStudentCourses(studentId);
    }
}
