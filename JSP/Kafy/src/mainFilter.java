

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

import org.jboss.resteasy.spi.HttpRequest;

/**
 * Servlet Filter implementation class mainFilter
 */
@WebFilter(filterName = "mainFilter", urlPatterns="*" ) 
public class mainFilter implements Filter {

    /**
     * Default constructor. 
     */
    public mainFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest maRequete = (HttpServletRequest) request;
		HttpServletResponse maReponse = (HttpServletResponse) response;

		String uri = maRequete.getRequestURI();
		System.out.println("uri de la requete : "+uri);
		if("/TPJeuDeRole/selecPersoServlet".equals(uri) 
				|| uri.contains("Form") 
				|| uri.contains("style") 
				|| uri.contains("images")){
			chain.doFilter(maRequete, maReponse);
		}else if( maRequete.getSession().getAttribute("persoSelec")== null){
			maReponse.sendRedirect( "./selecPersoServlet" );
		}else{
			chain.doFilter(maRequete, maReponse);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
