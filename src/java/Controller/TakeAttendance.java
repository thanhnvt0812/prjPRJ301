/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DAO;
import Entity.AttendanceInformation;
import Entity.SubjectAttendance;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class TakeAttendance extends HttpServlet {

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
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        String user = (String) request.getSession().getAttribute("username");
        List<SubjectAttendance> listSubAttendance = dao.getSubjectAttendanceDetail(user);
        request.setAttribute("listSubAttendance", listSubAttendance);
        String subjectCode = request.getParameter("subjectCode");
        String className = request.getParameter("className");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        session.setAttribute("subjectCode", subjectCode);
        session.setAttribute("className", className);
        session.setAttribute("startTime", startTime);
        session.setAttribute("endTime", endTime);
        if (subjectCode != null && className != null && startTime != null && endTime != null) {
            List<AttendanceInformation> listAttendanceInformations = dao.getAttendanceInformation(subjectCode, className, startTime, endTime, user);
            request.setAttribute("listAttendanceInformations", listAttendanceInformations);
            session.setAttribute("list", listAttendanceInformations);
        }
        request.getRequestDispatcher("TakeAttendance.jsp").forward(request, response);
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
        processRequest(request, response);
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
        DAO dao = new DAO();
        List<AttendanceInformation> list = (List<AttendanceInformation>) request.getSession().getAttribute("list");
        String subjectCode = (String) request.getSession().getAttribute("subjectCode");
        String className = (String) request.getSession().getAttribute("className");
        String startTime = (String) request.getSession().getAttribute("startTime");
        String endTime = (String) request.getSession().getAttribute("endTime");
        String userName = (String) request.getSession().getAttribute("username");
        for (int i = 0; i < list.size(); i++) {
            int attendStatus = Integer.parseInt(request.getParameter("attendance" + list.get(i).getRollNumber()));
            String notes = request.getParameter("note" + list.get(i).getRollNumber());
            list.get(1).setNotes(notes);
            dao.takeAttendance(attendStatus, list.get(i).getNotes(), subjectCode, list.get(i).getRollNumber(), userName, startTime, endTime);
        }
        List<SubjectAttendance> listSubAttendance = dao.getSubjectAttendanceDetail(userName);
        request.setAttribute("listSubAttendance", listSubAttendance);
        List<AttendanceInformation> listAttendanceInformations = dao.getAttendanceInformation(subjectCode, className, startTime, endTime, userName);
        request.setAttribute("listAttendanceInformations", listAttendanceInformations);
        request.getRequestDispatcher("TakeAttendance.jsp").forward(request, response);
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
