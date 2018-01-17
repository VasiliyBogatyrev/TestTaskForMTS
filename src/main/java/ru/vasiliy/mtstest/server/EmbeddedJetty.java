package ru.vasiliy.mtstest.server;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

public class EmbeddedJetty {
    private static final Logger logger = LoggerFactory.getLogger(EmbeddedJetty.class);
    private static final int PORT = 9290;
    private static final String CONTEXT_PATH = "/";
    private static final String CONFIG_LOCATION = "ru.vasiliy.mtstest.config";
    private static final String MAPPING_URL = "/*";

    public static void main(String[] args) throws Exception{
        new EmbeddedJetty().startJetty(PORT);
    }

    private void startJetty(int port) throws Exception {
        logger.debug("Starting server at port {}", port);
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(port);

        server.setHandler(getServletContextHandler(getContext()));

        startDB();
        server.start();
        logger.info("Server started at port {}", port);
        server.join();
    }

    private static void startDB() throws SQLException {
        Server server1 = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
        logger.info("h2 server started at " + server1.getURL());
    }

    private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        return contextHandler;
    }

    private static WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }
}
