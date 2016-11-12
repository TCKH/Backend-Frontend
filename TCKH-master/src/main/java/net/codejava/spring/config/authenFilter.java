package net.codejava.spring.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class authenFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setCharacterEncoding("UTF-8");
		  String path = httpRequest.getRequestURI();
		  if (path.contains("/login")) {
		   chain.doFilter(request, response); // Just continue chain.
		  }
		  else {
		   HttpServletResponse httpResponse = (HttpServletResponse) response;
		   HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(httpRequest);
		   // Get token from header
		   String authToken = requestWrapper.getHeader("Authorization");
		   System.out.println(authToken);
		   if (authToken != null && authToken.length() > 0) {
			   
			 
		    /*if (authenticationService.isValid(authToken)) {
		     chain.doFilter(requestWrapper, response); // Just continue chain.
		    }
		    else {
		     // Un authorize
		     httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		    }*/
		   }
		   else {
		    // Un authorize
		    httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		   }
		  }
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
