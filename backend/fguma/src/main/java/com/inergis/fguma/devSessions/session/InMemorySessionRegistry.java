package com.inergis.fguma.devSessions.session;

import com.inergis.fguma.entities.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class InMemorySessionRegistry {
    private Map<String, String> SESSIONS = new HashMap<>();
    private Map<String, Date> SESSIONTIMER = new HashMap<>();

    public String addSession(String user) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        String sessionId = generateSessionId();
        SESSIONS.put(sessionId, user);
        SESSIONTIMER.putIfAbsent(sessionId, new Date());
        return sessionId;
    }

    public void removeSession(String sessionId) {
        SESSIONS.remove(sessionId);
        SESSIONTIMER.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return SESSIONS.get(sessionId);
    }

    private String generateSessionId() {
        return new String(
                Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8))
        );
    }
}
