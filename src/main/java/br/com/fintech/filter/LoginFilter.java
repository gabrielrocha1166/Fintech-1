package br.com.fintech.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class LoginFilter implements Filter {
       
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		
		if (session.getAttribute("usuario") == null && !url.contains("resources")) {
			request.setAttribute("erro", "Entre com o usu�rio e senha!");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	
	}
	
	
	
	
	
    public LoginFilter() {
        super();

    }

	public void destroy() {

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

