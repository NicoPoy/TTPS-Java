package ttps;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FiltroLenguajeCliente
 */

@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "archivoEsp", value = "textos_es.properties"),
				@WebInitParam(name = "archivoEng", value = "textos_en.properties")
		})

public class FiltroLenguajeCliente implements Filter {
	
	private DiccionarioDePalabras dp = new DiccionarioDePalabras();
	private String lenguaje;
	
	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

    /**
     * Default constructor. 
     */
    public FiltroLenguajeCliente() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest r = (HttpServletRequest) request;
		
		if (r.getLocale().getLanguage().equals( new Locale("es").getLanguage()) ) {
			lenguaje = "textos_es.properties";
			File español = new File(request.getServletContext().getRealPath("/") + "textos_es.properties");
			if(! español.exists() ) {
				dp.generarPropertiesEspañol(español);
			}
		} else {
			lenguaje = "textos_en.properties";
			File ingles = new File(request.getServletContext().getRealPath("/") + "textos_en.properties");
			if(! ingles.exists() ) {
				dp.generarPropertiesIngles(ingles);
			}
		}
		request.getServletContext().setAttribute("lenguaje", lenguaje);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
