package az.orient.course.dao;


import az.orient.course.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
@NoArgsConstructor
@AllArgsConstructor
public class StudentDaoImpl implements StudentDao{

    DataSource datasource;







   @Override
   public List<Student> getStudentList() throws Exception {
      JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);
      String sql="SELECT * FROM qrup46db.student\n" +
              "where active=1";
     List<Student>studentList= jdbcTemplate.query(sql,new BeanPropertyRowMapper(Student.class));

      return studentList;
   }

   @Override
   public void addStudent(Student student) throws Exception {
      JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);
      String sql="insert  into qrup46db.student(name,surname,address,dob,phone)\n" +
              "values(?,?,?,?,?)";
      jdbcTemplate.update(sql, new Object[]{student.getName(),student.getSurname(),student.getAddress(),student.getDob(),student.getPhone()});

   }

   @Override
   public Student getStudentById(Long studentId) throws Exception {
      JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);
      String sql="SELECT * FROM qrup46db.student\n" +
              "where active=1 and id=?";
      List<Student>studentList= jdbcTemplate.query(sql,new Object[]{studentId},new BeanPropertyRowMapper(Student.class));

           if(studentList.size()>0){

               return studentList.get(0);


              }

      else{
         return null;
      }
   }

   @Override
   public void uptadeStudent(Student student) throws Exception {
      JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);
      String sql="update qrup46db.student set name=?, set surname=?,set address=?,set dob=?,set phone=?\n" +
              "where id=?";
      jdbcTemplate.update(sql, new Object[]{student.getName(),student.getSurname(),student.getAddress(),student.getDob(),student.getPhone(),student.getId()});

   }



   @Override
   public void deleteStudent(Long studentId) throws Exception {
      JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);
      String sql="update qrup46db.student set active=0\n" +
              "where id=?";
      jdbcTemplate.update(sql, new Object[] {studentId});

   }

   @Override
   public Integer studentCount() throws Exception {
      JdbcTemplate jdbcTemplate=new JdbcTemplate(datasource);
      String sql="Select count(*) from qrup46db.student where active =1";
      Integer studentCount=jdbcTemplate.queryForObject(sql,Integer.class);





      return studentCount;
   }

}

