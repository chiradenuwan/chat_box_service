package lk.ijse.webservice.resource_access.sevlet;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import lk.ijse.webservice.resource_access.modal.ChatDto;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ChatSender extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String s = CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        System.out.println(s);
        ChatDto chatDto = new Gson().fromJson(s, ChatDto.class);
        chatDto.setDate(new Timestamp(System.currentTimeMillis()).toString());
        System.out.println(chatDto);
        ArrayList<ChatDto> chatList = (ArrayList<ChatDto>) getServletContext().getAttribute("chat");
        if (chatList == null) {
            ArrayList<ChatDto> allchats = new ArrayList<>();
            allchats.add(chatDto);
            getServletContext().setAttribute("chat", allchats);
        } else {
            chatList.add(chatDto);
        }
    }
}
