package persistence;

import logic.Student;
import org.junit.jupiter.api.Test;

class CRUDestudiante {

    private  StudentDAOFactoty factoty = new StudentDAOFactoty();

    @Test
    void addStudent() {
        factoty.createStudentDAO().addStudent( new Student(0,"Barrera Daniela","Inter-Curso", 10,"Danza","10"));
    }

    @Test
    void updateStudent() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByCode() {
    }

    @Test
    void getAllStudents() {
        factoty.createStudentDAO().getAllStudents()
                .forEach(System.out::println);
    }
}