/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import entity.Attendance;
import entity.Report;
import entity.Session;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class AttendanceReportController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AttendanceReportController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceReportController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int instructorid = Integer.parseInt(request.getParameter("iid"));
        int groupid = Integer.parseInt(request.getParameter("gid"));
        int subjectid = Integer.parseInt(request.getParameter("subid"));
        SessionDBContext sessDB = new SessionDBContext();
        StudentDBContext stuDB = new StudentDBContext();
        ArrayList<Student> stus = new ArrayList<>();
        ArrayList<Session> sess = sessDB.getSessions(instructorid, groupid, subjectid);
        stus = stuDB.list(instructorid, groupid, subjectid);
        AttendanceDBContext attDB = new AttendanceDBContext();
        for (Student st : stus) {
            ArrayList<Attendance> atts = new ArrayList<>();
            atts = attDB.getAttendanceReport(groupid, subjectid, instructorid, st.getId());
            st.setAtts(atts);
            Report r = new Report();
            r = attDB.getAbsentPercentage(groupid, subjectid, instructorid, st.getId());
            st.setReport(r);
        }
        request.setAttribute("students", stus);
        request.setAttribute("ses", sess);
        
        request.getRequestDispatcher("../lecturer/attendance_report.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
