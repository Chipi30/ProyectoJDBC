package com.example.proyectojdbc;

import com.google.gson.Gson;
import logic.Event;
import persistence.CRUDdevent;
import persistence.CRUDdicipline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletEvent", value = "/servlet-event")
public class ServletEvent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");

        String option = request.getParameter("option");

        switch (option) {
            case "0": {
                Gson gson = new Gson();
                String stAux = gson.toJson(new CRUDdevent().getAllEvents());

                try (
                        PrintWriter out = response.getWriter();
                ) {
                    out.println(stAux);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");

        String option = request.getParameter("option");

        switch (option) {
            case "0":
                String name = request.getParameter("name");
                new CRUDdevent().addEvent(new Event(0, name));
                try (
                        PrintWriter out = response.getWriter();
                ) {
                    out.println("Guardado");
                }
                break;
            case "1":
                String modname = request.getParameter("name");
                String id = request.getParameter("id");
                new CRUDdevent().updateEvent(new Event(Integer.parseInt(id), modname));
                try (
                        PrintWriter out = response.getWriter();
                ) {
                    out.println("Actualizado");
                }
                break;
            case "2":
                String delid = request.getParameter("id");

                String msg = "Cursando";

                try {
                    new CRUDdevent().delete(delid);
                } catch (Exception e) {
                    msg = "Error, evento en curso";
                }

                try (
                        PrintWriter out = response.getWriter();
                ) {
                    out.println(msg);
                }
                break;
        }
    }
}
