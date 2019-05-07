package com.asiainfo.readinglist.filter;
 
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;
 
/**
 * 增加输出日志traceRootId
 */
@Slf4j
@Component
@WebFilter(urlPatterns = "/**",filterName = "logbackFilter")
public class LogbackFilter implements Filter {
 
	private static final String UNIQUE_ID = "traceRootId";
 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		boolean bInsertMDC = insertMDC();
		try {
			chain.doFilter(request, response);
		} finally {
		}
	}
 
	private boolean insertMDC() {
		UUID uuid = UUID.randomUUID();
		String uniqueId = uuid.toString();
		MDC.put(UNIQUE_ID, uniqueId);
		return true;
	}
 
	@Override
	public void destroy() {
		MDC.remove(UNIQUE_ID);
	}
 
}