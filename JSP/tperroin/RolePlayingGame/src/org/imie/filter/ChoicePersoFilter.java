package org.imie.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imie.tperroin.model.Personnage;

/**
 * Servlet Filter implementation class ChoicePersoFilter
 */
@WebFilter(filterName = "ChoicePersoFilter", urlPatterns = "*")
public class ChoicePersoFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ChoicePersoFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();


		boolean doFilter = true;
		if (uri.contains("jsp") || uri.contains("css")
				|| uri.contains("PersonnageChoiceController")) {
			doFilter = false;
		}
		if (doFilter) {
			if (httpRequest.getSession().getAttribute("personnageConnected") == null) {
				httpresponse.sendRedirect("./PersonnageChoiceController");
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
	}

}
