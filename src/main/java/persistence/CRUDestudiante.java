package persistence;

import logic.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CRUDestudiante implements StudentDAO{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/club_deportivo";
    private static final String USER = "root";
    private static final String PASSWD = "";

    @Override
    public void CargarDatos(){

    }

    @Override
    public void addStudent(Student student) {
        try {
            Class.forName( DRIVER );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection =
                    DriverManager.getConnection( URL);
                ){
            Statement statement = connection.createStatement();

            int ID = student.getID();
            String name = student.getName();
            String evento = student.getEvento();
            int curso = student.getCurso();
            String diciplina = student.getDiciplina();
            String posicion = student.getPosicion();

            final String query = "INSERT INTO estudiante VALUES(" + "'" + ID + "','" + name + "','" + evento + "','"  +  "','" + curso + "','" + diciplina + "','" + posicion + "')";
            statement.execute( query );
            System.out.println( query );

            if (Boolean.parseBoolean(query)){
                System.out.println("Registrado con exito");
            }else{
                System.out.println("Error al registrar estudiante");
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            Class.forName( DRIVER );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection =
                    DriverManager.getConnection( URL,USER, PASSWD);
        ){
            Statement statement = connection.createStatement();

            int ID = student.getID();
            String name = student.getName();
            String evento = student.getEvento();
            int curso = student.getCurso();
            String diciplina = student.getDiciplina();
            String posicion = student.getPosicion();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String code) {

    }

    @Override
    public Student findByCode(String code) {
        return null;
    }


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try(Connection connection =
                DriverManager.getConnection(URL,USER, PASSWD);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("select * from estudiante");
                ){
            while( result.next()){
                int ID = Integer.valueOf(result.getString( "ID" ));
                String name = result.getString( "name" );
                String evento = result.getString( "evento" );
                int curso = Integer.valueOf(result.getString("curso"));
                String diciplina = result.getString( "diciplina" );
                String posicion = result.getString( "posicion" );

                students.add( new Student(ID, name,evento,curso,diciplina,posicion));
            }

            return students;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
    @Override
    public void close() throws Exception {

    }
}
