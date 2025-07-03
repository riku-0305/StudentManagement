package raisetech.Student.Management.Domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.Student.Management.Data.Student;
import raisetech.Student.Management.Data.StudentCourses;

@Getter
@Setter

public class StudentDetail {

  private Student student;
  private List<StudentCourses> studentCoursesList;

}
