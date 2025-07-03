package raisetech.Student.Management.Data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {


  private String id;
  private String name;
  private String reading;
  private String nickName;
  private String mailAddress;
  private int age;
  private String gender;
  private String remark;
  private boolean isDelete;

}
