package raisetech.Student.Management.Controller.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.Student.Management.Domain.StudentDetail;
import raisetech.Student.Management.Data.Student;
import raisetech.Student.Management.Data.StudentCourses;

@Component
public class StudentConverter {


  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourses> studentCourses) {

    List<StudentDetail> studentDetails = new ArrayList<>();

    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentCourses> convertStudentCourses = studentCourses.stream()
          .filter(studentCourse -> student.getId().equals(studentCourse.getStudentsId()))
          .collect(Collectors.toList());
      studentDetail.setStudentCoursesList(convertStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }

}
