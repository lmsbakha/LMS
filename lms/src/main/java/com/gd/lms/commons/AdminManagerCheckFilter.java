package com.gd.lms.commons;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/loginCheck/adminManagerCheck/*")
public class AdminManagerCheckFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = null;
		if(request instanceof HttpServletRequest) {
			log.debug(TeamColor.PCW + "AdminManagerCheckFilter 브라우저 접속" + TeamColor.TEXT_RESET);
			session = ((HttpServletRequest)request).getSession();
			if((int)session.getAttribute("sessionLevel") < 3) { // 행정 or 총관리자가 아니라면
				log.debug(TeamColor.PCW + "행정 또는 총 관리자외 접근 불가합니다" + TeamColor.TEXT_RESET);
				((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginCheck/index");
				return;
			}
		} else {
			log.debug(TeamColor.PCW + "AdminManagerCheckFilter 브라우저 요청이 아닙니다." + TeamColor.TEXT_RESET);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
