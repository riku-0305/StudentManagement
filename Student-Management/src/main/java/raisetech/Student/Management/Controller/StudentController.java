package raisetech.Student.Management.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.Controller.Converter.StudentConverter;
import raisetech.Student.Management.Data.Student;
import raisetech.Student.Management.Data.StudentCourses;
import raisetech.Student.Management.Domain.StudentDetail;
import raisetech.Student.Management.Service.StudentService;

@Controller

public class StudentController {

  private final StudentService service;
  private final StudentConverter converter;


  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }


  @GetMapping("/studentList")
  public String getStudentList(Model model) {

    List<Student> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentCoursesList();

    model.addAttribute("studentList", converter.convertStudentDetails(students,studentCourses));

    return "studentList";
  }

  @GetMapping("/studentsCourses")
  public List<StudentCourses> getStudentCoursesList() {
    return service.searchStudentCoursesList();
  }
}
