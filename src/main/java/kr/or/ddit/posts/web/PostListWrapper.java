package kr.or.ddit.posts.web;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PostListWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> map;
	
	public PostListWrapper(HttpServletRequest request) {
		super(request);
		
		// 기존 request 객체의 파라미터 map을 복사
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		// 파라미터를 확인하고 없으면 등록
		String[] pages = map.get("page");
		String[] pageSizes = map.get("pageSize");
		
		// null이나 whiteSpace 처리
		if(pages==null || pages[0].equals("")){
			map.put("page", new String[]{"1"});
		}
		
		if(pageSizes==null || pageSizes[0].equals("")){
			map.put("pageSize", new String[]{"10"});
		}
		
	}

	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values != null)
			return values[0];
		else
			return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}
	

}
