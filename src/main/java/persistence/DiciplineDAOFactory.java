package persistence;

public class DiciplineDAOFactory {
    public DiciplineDAO createDiciplineDAO(){
        return new CRUDdicipline();
    }
}
