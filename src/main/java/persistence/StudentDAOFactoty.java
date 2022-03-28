package persistence;

public class StudentDAOFactoty {
    public StudentDAO createStudentDAO(){

        return new CRUDestudiante();
    }
}
