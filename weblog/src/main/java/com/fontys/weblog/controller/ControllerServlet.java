/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fontys.weblog.controller;

import com.fontys.weblog.model.Posting;
import com.fontys.weblog.service.WebLogService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sander
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet", "/addBlog", "/blog", "/addComment"})
public class ControllerServlet extends HttpServlet {
    WebLogService service = new WebLogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();        
        if(path.equals("/addBlog")){
            RequestDispatcher view = request.getRequestDispatcher("view/myBlogAdm.jsp");
            view.forward(request, response);
        }
        else if(path.equals("/blog")){
            List<Posting> postings = service.getPostings();
            request.setAttribute("postings", postings);           
            RequestDispatcher view = request.getRequestDispatcher("view/myBlog.jsp");
            view.forward(request, response);
        }
        else if(path.equals("/addComment")){
            String id = request.getParameter("id");
            request.setAttribute("id", id);     
            RequestDispatcher view = request.getRequestDispatcher("view/newComment.jsp");
            view.forward(request, response);          
        }
        else {
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }         
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
        String path = request.getServletPath();
        if(path.equals("/addBlog")){
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Posting newPost = new Posting(title, content);
            try {
                service.addPosting(newPost);
                List<Posting> postings = service.getPostings();
                request.setAttribute("postings", postings);           
                RequestDispatcher view = request.getRequestDispatcher("view/myBlog.jsp");
                view.forward(request, response);
            } catch (IllegalArgumentException illegalArgumentException) {
                RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                view.forward(request, response);
            }
            
        }
        if(path.equals("/addComment")){
            Long id = Long.parseLong(request.getParameter("id"));
            String content = request.getParameter("content");
            try {
                service.addCommentToPosting(id, content);
                List<Posting> postings = service.getPostings();
                request.setAttribute("postings", postings);           
                RequestDispatcher view = request.getRequestDispatcher("view/myBlog.jsp");
                view.forward(request, response);
            } catch (IllegalArgumentException illegalArgumentException) {
                RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                view.forward(request, response);
            }
        }
    }
}
