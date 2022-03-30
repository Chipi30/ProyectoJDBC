package persistence;

import logic.Dicipline;
import logic.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDdevent implements EventDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/club_deportivo";
    private static final String USER = "root";
    private static final String PASSWD = "";


    @Override
    public void CargarDatos() {

    }

    @Override
    public void addEvent(Event event) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD)
        ) {
            Statement statement = connection.createStatement();

            int ID = event.getId();
            String name = event.getNombre();

            final String query = "INSERT INTO `evento` (`id`, `nombre`) VALUES (NULL, '" + name +"');";
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
    public void updateEvent(Event event) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
        ) {
            Statement statement = connection.createStatement();

            int ID = event.getId();
            String name = event.getNombre();

            final String query = "UPDATE `evento` SET `nombre` = '"+name +"' WHERE `ID` = "+ID+"";
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

            final String query = "DELETE FROM evento WHERE id = '"+code+"'";
            statement.execute(query);
            System.out.println(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Dicipline findByCode(String code) {
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("select * from evento")
        ) {
            while (result.next()) {
                int id = Integer.parseInt(result.getString("id"));
                String name = result.getString("nombre");
                events.add(new Event(id, name));
            }

            return events;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
