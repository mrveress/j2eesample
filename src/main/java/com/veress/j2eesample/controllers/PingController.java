package com.veress.j2eesample.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ping")
public class PingController extends HttpServlet{
    
    @Override
    protected void doGet(
        HttpServletRequest req,
        HttpServletResponse res
    ) throws ServletException, IOException {
        PingData outputPingData = new PingData(2, "Test1");
        String outputJsonString = new Gson().toJson(outputPingData);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        out.print(outputJsonString);
        out.flush();
    }

    public class PingData {
        public int id;
        public String name;

        public PingData(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
}
