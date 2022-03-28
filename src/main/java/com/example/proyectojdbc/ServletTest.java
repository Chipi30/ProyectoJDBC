package com.example.proyectojdbc;
import com.google.gson.Gson;
import logic.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "servletTest", value = "/servlet-test")
public class ServletTest extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    //recuperarlos todos o solo un estudiante
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        List<Student> students = Arrays.asList(
                new Student(435,"Barrera Daniela","Inter-Curso", 10,"Danza","10"),
                new Student(435,"Pedraza Julian","Inter-Colegiados", 11,"Voleibol","5"),
                new Student(435,"Melanie Mesa","Campeonato", 9,"Canto","2"));

        Gson gson = new Gson();
        String stAux = gson.toJson( students );
        String ID = request.getParameter("ID");
        try(
                PrintWriter out = response.getWriter();
                ){
            out.println(stAux);
        }
    }
//se agregar en
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String ID = request.getParameter("ID");
        String name = request.getParameter("name");
        String evento = request.getParameter("evento");
        String curso = request.getParameter("curso");
        String diciplina = request.getParameter("diciplina");
        String posicion = request.getParameter("posicion");
        try( PrintWriter out = response.getWriter()){
            out.println( ID + " " + name + " " + evento + " " + curso + " " + diciplina + " " + posicion );
        }
    }
   //patch modificar y put reemplazar

}
