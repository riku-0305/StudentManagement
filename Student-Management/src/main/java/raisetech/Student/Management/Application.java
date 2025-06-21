package raisetech.Student.Management;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {


  private final Map<String, String> student = new HashMap<>();


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @PostMapping("/studentInfo")
  public void setInfo(String name, String age) {
    student.put(name, age);
  }

  @GetMapping("/studentList")
  public Map<String,String> getInfo() {
    Map<String,String> studentInfo = new HashMap<>();
    for (Map.Entry<String,String> entry : student.entrySet())
      studentInfo.put(entry.getKey() + "さん", entry.getValue() + " 歳");
    return studentInfo;
  }

  @PostMapping("/updateStudent")
  public void updateStudent(String oldName, String newName, String age) {
    Entry<String, String> updateStudent = student.entrySet()
        .stream()
        .filter(v -> v.getKey().matches(oldName))
        .findFirst()
        .orElse(null);

    if (updateStudent != null) {
      student.remove(oldName);
      student.put(newName, age);
    }
  }
}
