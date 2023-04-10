package az.orient.course.model;

import lombok.Data;

import java.util.Date;


@Data
public class Student {

    private long id;
    private String name;
    private String surname;
    private String address;
    private Date dob;
    private String phone;
}
