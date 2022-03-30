package persistence;

import logic.Dicipline;
import logic.Student;

import java.util.List;

public interface DiciplineDAO {

    void CargarDatos();

    void addDicipline(Dicipline dicipline);

    void updateDicipline(Dicipline dicipline);

    void delete(String code);

    Dicipline findByCode(String code);

    List<Dicipline> getAllDicipline();

}
