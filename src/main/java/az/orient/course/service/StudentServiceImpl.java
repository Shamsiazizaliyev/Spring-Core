package az.orient.course.service;


import az.orient.course.dao.StudentDao;
import az.orient.course.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

 private final StudentDao studentDao;



    @Override
    public List<Student> getStudentList() throws Exception {
        return studentDao.getStudentList();
    }

    @Override
    public void addStudent(Student student) throws Exception {
     studentDao.addStudent(student);
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public void uptadeStudent(Student student) throws Exception {
              studentDao.uptadeStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
          studentDao.deleteStudent(studentId);
    }

    @Override
    public Integer studentCount() throws Exception {
        return studentDao.studentCount();
    }
}
