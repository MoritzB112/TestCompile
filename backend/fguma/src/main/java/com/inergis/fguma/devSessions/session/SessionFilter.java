package com.inergis.fguma.devSessions.session;

import com.inergis.fguma.devSessions.user.CurrentUser;
import com.inergis.fguma.devSessions.user.CurrentUserService;
import com.inergis.fguma.entities.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SessionFilter extends OncePerRequestFilter {
    @Autowired
    private InMemorySessionRegistry sessionRegistry;
    @Autowired
    private CurrentUserService currentUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(token == null) {
            chain.doFilter(request, response);
            return;
        }
        String session = sessionRegistry.getSession(token);
        if(session == null) {
            chain.doFilter(request, response);
            return;
        }
        CurrentUser currentUser = currentUserService.loadUserByUsername(session);

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(currentUser, null, currentUser.getAuthorities());
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(auth);

        chain.doFilter(request, response);
    }
}
