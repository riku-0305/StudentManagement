package raisetech.Student.Management.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.Controller.Converter.StudentConverter;
import raisetech.Student.Management.Data.Student;
import raisetech.Student.Management.Data.StudentCourses;
import raisetech.Student.Management.Domain.StudentDetail;
import raisetech.Student.Management.Service.StudentService;

@RestController

public class StudentController {

  private final StudentService service;
  private final StudentConverter converter;


  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }


  @GetMapping("/student")
  public List<StudentDetail> getStudentList() {

    List<Student> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentCoursesList();

    return converter.convertStudentDetails(students, studentCourses);
  }

  @GetMapping("/studentsCourses")
  public List<StudentCourses> getStudentCoursesList() {
    return service.searchStudentCoursesList();
  }
}
