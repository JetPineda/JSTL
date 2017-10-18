/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 686623
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");

        if (action == null && userName == null) {

            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("logOut")) {
            session.invalidate();
            request.setAttribute("message", "Logged Out");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            request.setAttribute("username", userName);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        String username = request.getParameter("username");
        HttpSession session = request.getSession();

        if (action.equalsIgnoreCase("add")) {

            if (request.getParameter("item").isEmpty()) {
                request.setAttribute("message", "You must enter an item to add");
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

            } else {
                ((ArrayList<String>) session.getAttribute("list")).add(request.getParameter("item"));
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("delete")) {

            String toDelete = request.getParameter("toDelete");
            if (toDelete.isEmpty()) {
                request.setAttribute("message", "You must select an item to delete");
            } else {
                ((ArrayList<String>) session.getAttribute("list")).remove(Integer.parseInt(toDelete));
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("register") && !username.isEmpty()) {

            session.setAttribute("username", username);
            request.setAttribute("username", username);
            session.setAttribute("list", new ArrayList<>());
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("register") && username.isEmpty()) {
            request.setAttribute("message", "You must give a username to register");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        }
    }
}
