package persistence;

public class EventDAOFactory {
    public EventDAO createEventDAO(){
        return new CRUDdevent();
    }
}
