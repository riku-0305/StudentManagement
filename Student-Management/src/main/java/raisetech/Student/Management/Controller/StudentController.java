package raisetech.Student.Management.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.Repository.Data.Student;
import raisetech.Student.Management.Repository.Data.StudentCourses;
import raisetech.Student.Management.Service.StudentService;

@RestController

public class StudentController {

  private StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @Autowired


  @GetMapping("/student")
  public List<Student> getStudentList() {
    return service.searchStudentList();
  }

  @GetMapping("/studentsCourses")
  public List<StudentCourses> getStudentCoursesList() {
    return service.searchStudentCoursesList();
  }


}
