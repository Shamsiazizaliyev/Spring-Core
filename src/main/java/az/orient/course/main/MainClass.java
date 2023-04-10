package az.orient.course.main;

import az.orient.course.dao.StudentDao;
import az.orient.course.dao.StudentDaoImpl;
import az.orient.course.model.Student;
import az.orient.course.service.StudentService;
import az.orient.course.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc=new Scanner(System.in);
       ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
         DataSource dataSource = (DataSource) context.getBean("datasource");
         StudentDao studentDao= new StudentDaoImpl(dataSource);
         StudentService studentService=new StudentServiceImpl(studentDao);


        try {
            switch (sc.next())
            {
                case "view":
                    List<Student>studentList= studentDao.getStudentList();
                    System.out.println(studentList);
                    break;
                case "add":
                    Student st=new Student();

                    st.setName(sc.next());
                    st.setSurname(sc.next());
                    st.setAddress(sc.next());
                    st.setDob(df.parse(sc.next()));
                    st.setPhone(sc.next());

                    studentDao.addStudent(st);
                    System.out.println("succes");
                case "count":
                    System.out.println( studentDao.studentCount());
            }
            main(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(student.getName()+" "+student.getSurname());




    }
}
