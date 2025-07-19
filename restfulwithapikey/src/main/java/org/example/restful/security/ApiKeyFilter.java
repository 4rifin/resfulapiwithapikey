package org.example.restful.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Create the API Key Authentication Filter
 */
public class ApiKeyFilter extends OncePerRequestFilter {
    private static final String API_KEY_HEADER = "x-api-key";
    private static final String VALID_API_KEY = "your-api-key";

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader(API_KEY_HEADER);

        if (VALID_API_KEY.equals(apiKey)) {
            SecurityContextHolder.getContext().setAuthentication(new ApiKeyAuthenticationToken(apiKey));
            filterChain.doFilter(request, response);
        }else{
            response.setStatus(400);
            response.getWriter().write("invalid api-key");

        }
    }
}
