package persistence;

import logic.Dicipline;
import logic.Event;

import java.util.List;

public interface EventDAO {

    void CargarDatos();

    void addEvent(Event event);

    void updateEvent(Event event);

    void delete(String code);

    Dicipline findByCode(String code);

    List<Event> getAllEvents();
}
