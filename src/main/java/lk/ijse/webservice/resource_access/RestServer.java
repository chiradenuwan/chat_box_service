package lk.ijse.webservice.resource_access;

import lk.ijse.webservice.resource_access.api.ResourceAccessRest;
import lk.ijse.webservice.resource_access.sevlet.ChatConnector;
import lk.ijse.webservice.resource_access.sevlet.ChatReceiver;
import lk.ijse.webservice.resource_access.sevlet.ChatSender;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class RestServer {
    private Server server;


    public void start() throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        context.addServlet(ResourceAccessRest.class, "/hello");
        context.addServlet(ChatConnector.class, "/connector");
        context.addServlet(ChatReceiver.class, "/reciever");
        context.addServlet(ChatSender.class, "/sender");
        server.setHandler(context);
        server.start();
        server.join();
    }
}