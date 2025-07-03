package raisetech.Student.Management.Data;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class StudentCourses {

  private String coursesId;
  private String studentsId;
  private String coursesName;
  private LocalDate startDate;
  private LocalDate expectedEndDate;

}
