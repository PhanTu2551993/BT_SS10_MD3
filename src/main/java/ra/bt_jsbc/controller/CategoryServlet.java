package ra.bt_jsbc.controller;

import ra.bt_jsbc.model.Category;
import ra.bt_jsbc.service.CategoryServiceImpl;
import ra.bt_jsbc.service.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ICategoryService categoryService;
    public void init() {
        categoryService = new CategoryServiceImpl();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listCategory(request, response);
                break;
            case "create":
                showNewForm(request,response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
//                try {
//                    deleteCategory(request, response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
                break;
            default:
                listCategory(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = categoryService.selectAllCategory();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = categoryService.selectCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("category", existingCategory);
        dispatcher.forward(request, response);
    }

//    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        userService.insertUser(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
//        dispatcher.forward(request, response);
//    }

//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        User book = new User(id, name, email, country);
//        userService.updateUser(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
//        dispatcher.forward(request, response);
//    }

//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userService.deleteUser(id);
//
//        List<User> listUser = userService.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
//        dispatcher.forward(request, response);
//    }
}