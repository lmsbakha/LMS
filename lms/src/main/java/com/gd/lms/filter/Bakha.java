package com.gd.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gd.lms.commons.TeamColor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/bakha/*")
public class Bakha extends HttpFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = null;
		String requestUri = ((HttpServletRequest) request).getRequestURI();
		if(request instanceof HttpServletRequest) {
			session = ((HttpServletRequest)request).getSession();
			if(requestUri.equals("/lms/Bakha/login") && session.getAttribute("sessionId") != null) {
				log.debug(TeamColor.PCW + "중복 로그인 방지" + TeamColor.TEXT_RESET);
				((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginCheck/index");
				return;
			}
		} else {
			log.debug(TeamColor.PCW + "브라우저 요청이 아닙니다." + TeamColor.TEXT_RESET);
		}
		
		chain.doFilter(request, response);
	}


}
