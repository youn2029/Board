package kr.or.ddit.posts.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PostListFiltter
 */
@WebFilter("/postList")
public class PostListFiltter implements Filter {

    public PostListFiltter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 전 처리
		HttpServletRequest req = (HttpServletRequest) request;
		
		// filter/servlet 요청 처리
		
		PostListWrapper postListWrapper = new PostListWrapper(req);
		
		chain.doFilter(postListWrapper, response);
		
		// 후 처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
