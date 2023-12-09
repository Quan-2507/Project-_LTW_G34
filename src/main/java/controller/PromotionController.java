package controller;

import bean.Promotions;
import service.PromotionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="PromotionController", value = "/promotions")
public class PromotionController extends  HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Promotions>all = PromotionService.getInstance().getAll();
        req.setAttribute("data",all);
        req.getRequestDispatcher("promotions.jsp").forward(req,resp);
    }
}
