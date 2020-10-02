package ttps;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "archivoLog", value = "logs.txt")
		})

public class FiltroLogDeAccesos implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogDeAccesos() {
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
		File archivoLog = new File(request.getServletContext().getRealPath("/") + "log.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivoLog, true));
		HttpServletRequest r = (HttpServletRequest) request;
		// pass the request along the filter chain
		chain.doFilter(request, response);
	
		String str = ( r.getRemoteAddr() + " " + r.getHeader("User-Agent") + " [" + LocalDateTime.now() + " ]" + r.getMethod() );	
		try {
			writer.write(str);
			writer.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
