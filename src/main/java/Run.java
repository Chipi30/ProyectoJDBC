import com.google.gson.Gson;
import logic.Student;
import persistence.CRUDdevent;
import persistence.CRUDdicipline;
import persistence.CRUDestudiante;

public class Run {

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new CRUDestudiante().getAllStudents()));
    }

}
