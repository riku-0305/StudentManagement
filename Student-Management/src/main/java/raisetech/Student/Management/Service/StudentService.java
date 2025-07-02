package raisetech.Student.Management.Service;

import java.beans.JavaBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Management.Repository.Data.Student;
import raisetech.Student.Management.Repository.Data.StudentCourses;
import raisetech.Student.Management.Repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    //30代の生徒情報をリスト化してコントローラーに返す。
    return repository.search().stream()
        .filter(v -> v.getAge() >= 30 && v.getAge() < 40)
        .toList();
  }

  public List<StudentCourses> searchStudentCoursesList() {
    //Javaコースの情報だけをリスト化してコントローラーに返す。
    return repository.searchCourses().stream()
        .filter(v -> v.getCoursesName().matches("Java"))
        .toList();
  }
}
