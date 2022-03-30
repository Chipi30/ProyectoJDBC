package persistence;

import logic.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CRUDestudiante implements StudentDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/club_deportivo";
    private static final String USER = "root";
    private static final String PASSWD = "";

    @Override
    public void CargarDatos() {

    }

    @Override
    public void addStudent(Student student) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD)
        ) {
            Statement statement = connection.createStatement();

            int ID = student.getID();
            String name = student.getName();
            String evento = student.getEvento();
            int curso = student.getCurso();
            String diciplina = student.getDiciplina();
            String posicion = student.getPosicion();

            final String query = "INSERT INTO `estudiante` (`ID`, `nombre`, `evento`, `curso`, `diciplina`, `posicion`) VALUES (NULL, '" + name + "', '" + evento + "', '" + curso + "', '" + diciplina + "', '" + posicion + "');";
            statement.execute(query);
            System.out.println(query);

            if (Boolean.parseBoolean(query)) {
                System.out.println("Registrado con exito");
            } else {
                System.out.println("Error al registrar estudiante");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
        ) {
            Statement statement = connection.createStatement();

            int ID = student.getID();
            String name = student.getName();
            String evento = student.getEvento();
            int curso = student.getCurso();
            String diciplina = student.getDiciplina();
            String posicion = student.getPosicion();

            final String query = "UPDATE `estudiante` SET `nombre` = '"+name +"', `evento` = '"+evento+"', `curso` = '"+curso+"' ,`diciplina` = '"+diciplina+"', `posicion` = '"+posicion+"' WHERE `ID` = "+ID+"";
            statement.execute(query);
            System.out.println(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String code) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
        ) {
            Statement statement = connection.createStatement();

            final String query = "DELETE FROM estudiante WHERE ID = '"+code+"'";
            statement.execute(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Student findByCode(String code) {
        return null;
    }


    @Override
    public List<Student> getAllStudents() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> students = new ArrayList<>();

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("select * from estudiante");
        ) {
            while (result.next()) {
                int ID = Integer.parseInt(result.getString("ID"));
                String name = result.getString("nombre");
                String evento = result.getString("evento");
                int curso = Integer.parseInt(result.getString("curso"));
                String diciplina = result.getString("diciplina");
                String posicion = result.getString("posicion");

                students.add(new Student(ID, name, evento, curso, diciplina, posicion));
            }

            return students;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Student getStudent(String id) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD)
        ) {
            final String query = "SELECT * FROM estudiante WHERE ID = '"+id+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setMaxRows(1);
            ResultSet rs = statement.executeQuery();
            rs.next();

            String nombre = rs.getString("nombre");
            String evento = rs.getString("evento");
            String curso = rs.getString("curso");
            String disciplina = rs.getString("diciplina");
            String posicion = rs.getString("posicion");

            return new Student(Integer.parseInt(id), nombre, evento, Integer.parseInt(curso), disciplina, posicion);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
