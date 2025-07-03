package raisetech.Student.Management.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Management.Data.Student;
import raisetech.Student.Management.Data.StudentCourses;
import raisetech.Student.Management.Repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<StudentCourses> searchStudentCoursesList() {
    return repository.searchCourses();
  }
}
