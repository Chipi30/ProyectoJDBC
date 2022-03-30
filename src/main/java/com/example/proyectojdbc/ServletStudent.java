package com.example.proyectojdbc;

import com.google.gson.Gson;
import logic.Student;
import persistence.CRUDestudiante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "servletStudent", value = "/servlet-student")
public class ServletStudent extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    //recuperarlos todos o solo un estudiante
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");

        Gson gson = new Gson();
        String stAux = gson.toJson(new CRUDestudiante().getAllStudents());

        try (
                PrintWriter out = response.getWriter()
        ) {
            out.println(stAux);
        }
    }

    //se agregar en
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String option = request.getParameter("option");
        CRUDestudiante crudEstudiante = null;

        switch (option) {
            //Agregar
            case "0":
                String name = request.getParameter("name");
                String evento = request.getParameter("evento");
                String curso = request.getParameter("curso");
                String diciplina = request.getParameter("disciplina");
                String posicion = request.getParameter("posicion");

                crudEstudiante = new CRUDestudiante();
                crudEstudiante.addStudent(new Student(0, name, evento, Integer.parseInt(curso), diciplina, posicion));

                try (PrintWriter out = response.getWriter()) {
                    out.println(name + " " + evento + " " + curso + " " + diciplina + " " + posicion + "" + option);
                }
                break;
            //Eliminar
            case "1":
                String deleteId = request.getParameter("deleteId");

                crudEstudiante = new CRUDestudiante();
                crudEstudiante.delete(deleteId);

                try (PrintWriter out = response.getWriter()) {
                    out.println("Elminar" + deleteId);
                }
                break;
            //Obtener 1 registro
            case "2":
                String id = request.getParameter("id");

                crudEstudiante = new CRUDestudiante();
                Student student = crudEstudiante.getStudent(id);

                try (PrintWriter out = response.getWriter()) {
                    out.println(new Gson().toJson(student));
                }

                break;
            //Actualziar un registro
            case "3":
                String modid = request.getParameter("id");
                String modname = request.getParameter("name");
                String modevento = request.getParameter("evento");
                String modcurso = request.getParameter("curso");
                String moddiciplina = request.getParameter("disciplina");
                String modposicion = request.getParameter("posicion");

                crudEstudiante = new CRUDestudiante();
                crudEstudiante.updateStudent(new Student(Integer.parseInt(modid), modname, modevento, Integer.parseInt(modcurso), moddiciplina, modposicion));
                break;

            default:
                try (PrintWriter out = response.getWriter()) {
                    out.println("invalid option");
                }
        }


    }



    //patch modificar y put reemplazar

}
