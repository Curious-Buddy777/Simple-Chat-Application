package com.alibou.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ChatApplication.class);

        // Bind to Railway's dynamic port
        Map<String, Object> props = new HashMap<>();
        String port = System.getenv("PORT");
        if (port != null) {
            props.put("server.port", port);
            System.out.println("✅ Binding to Railway dynamic port: " + port);
        } else {
            props.put("server.port", "8080");
            System.out.println("⚠️ No PORT env var found. Falling back to 8080.");
        }

        app.setDefaultProperties(props);
        app.run(args);
    }
}
