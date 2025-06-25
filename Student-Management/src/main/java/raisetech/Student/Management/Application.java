package raisetech.Student.Management;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  @Autowired
  private StudentRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @GetMapping("/student")
  public String getStudent() {
    List<Student> studentList = repository.searchByList();
/*Stringオブジェクトはイミュータブルな型のため +演算子の度に新しい(new)オブジェクトが生成されている。
  StringBuilderオブジェクトはミュータブルな型のため、バッファを拡大しながら文字列を追記しているため(newしない)
  元のオブジェクトの変更が行われている。
  なので+演算子などを多用する場合などでは、メモリ効率が良く、可読性の高いStringBuilderを用いた方がよい。
 */
    StringBuilder sb = new StringBuilder();
    for (Student s : studentList) {
      sb.append(s.getName());
      sb.append(" ");
      sb.append(s.getAge());
//    \nは改行という意味
      sb.append("歳\n");
    }
    return sb.toString();
  }

  @PostMapping("/student")
  public void registerStudent(String name, int age) {
    repository.registerStudent(name, age);
  }

  @PatchMapping("/student")
  public void updateStudent(String name, int age) {
    repository.updateStudent(name, age);
  }

  @DeleteMapping("/student")
  public void deleteStudent(String name) {
    repository.deleteStudent(name);
  }
}
