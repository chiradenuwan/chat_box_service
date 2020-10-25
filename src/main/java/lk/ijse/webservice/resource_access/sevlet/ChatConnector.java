package lk.ijse.webservice.resource_access.sevlet;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import lk.ijse.webservice.resource_access.modal.UserDto;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

public class ChatConnector extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String string = CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        HttpSession session = req.getSession();
        UserDto userDto = new Gson().fromJson(string, UserDto.class);
        userDto.setDate(new Timestamp(System.currentTimeMillis()).toLocalDateTime().toString());
        session.setAttribute("user", userDto);
    }
}
