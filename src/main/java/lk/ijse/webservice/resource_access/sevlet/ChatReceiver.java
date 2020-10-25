package lk.ijse.webservice.resource_access.sevlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lk.ijse.webservice.resource_access.modal.ChatDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ChatReceiver extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ArrayList<ChatDto> list = (ArrayList<ChatDto>) getServletContext().getAttribute("chat");
        System.out.println("lis obj : " + list);
        if (list != null) {
            String s = new Gson().toJson(list, new TypeToken<ArrayList<ChatDto>>() {
            }.getType());
            System.out.println(s);
            resp.getWriter().print(s);
        }
        else {
            resp.getWriter().print("No msg");
        }
    }
}
