package org.imie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class PersonnageConnexion
 */
@WebFilter(urlPatterns = "/*")
public class PersonnageConnexion implements Filter {

	/**
	 * Default constructor.
	 */
	public PersonnageConnexion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		Boolean doFilter = true;
		String uri = httpServletRequest.getRequestURI();
		if (uri.contains("jsp") || uri.contains("css")
				|| uri.contains("Connexion")) {
			doFilter = false;
		}
		if (doFilter) {
			if (httpServletRequest.getSession().getAttribute(
					"personnageConnecte") == null) {
				httpServletResponse.sendRedirect("./Connexion");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
