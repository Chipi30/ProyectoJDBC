package persistence;

import logic.Student;

import java.util.List;

public interface StudentDAO extends AutoCloseable {
    void CargarDatos();

    void addStudent(Student student);

    void updateStudent(Student student);

    void delete(String code);

    Student findByCode(String code);

    List<Student> getAllStudents();

    Student getStudent(String id);
}
