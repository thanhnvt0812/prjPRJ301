/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DAO;
import Dao.ListWeek;
import Entity.Dates;
import Entity.Slot;
import Entity.TeacherScheduleDetail;
import Entity.Weeks;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class TeacherSchedule extends HttpServlet {

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
        String user = (String) request.getSession().getAttribute("username");
        List<Weeks> listWeeks = new ArrayList<>();
        SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
        List<Weeks> list = ListWeek.list("20210510","20210516" ,"20210725");
        int weekID =1;
        for (Weeks o : list) {
            o.setId(weekID++);
            listWeeks.add(new Weeks(o.getId(), o.getWeekStart(), o.getWeekEnd()));
        }
        request.setAttribute("listWeeks", listWeeks);
        //-------------------------------------------------------------------------------------------
        DAO dao = new DAO();
        String index = request.getParameter("selectedDateWeek");
        if(index == null ) index = "1";
        int weeksID = Integer.parseInt(index);
        List<Dates> listDates = dao.Paging(weeksID);
        request.setAttribute("listDates", listDates);
        //--------------------------------------------------------------------------------------------
        List<Slot> listSlot = dao.getSlot();
        request.setAttribute("listSlot", listSlot);
        //-------------------------------------------------------------------------------------------
        List<TeacherScheduleDetail> listTchSchdDetail = new ArrayList<>();
        for (Dates o : listDates) {
            List<TeacherScheduleDetail> list1 = dao.getTeacherScheduleDetail(user, o.getDateTime());
            for (TeacherScheduleDetail o1 : list1) {
                listTchSchdDetail.add(o1);
            }
        }
        request.setAttribute("listTchSchdDetail", listTchSchdDetail);
        request.getRequestDispatcher("TeacherSchedule.jsp").forward(request, response);
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
