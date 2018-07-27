package kr.or.ddit.posts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.posts.dao.PostsDao;
import kr.or.ddit.posts.dao.PostsDaoInf;
import kr.or.ddit.posts.model.PostsVO;

public class PostsService implements PostsServiceInf {
	
	private PostsDaoInf postsDao = new PostsDao();

	/**
	* Method : getListPost
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : YSH
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 게시판의 게시글 페이지별 조회
	*/
	@Override
	public Map<String, Object> getListPost(Map<String, Integer> paramMap) {
		
		// 반환값 선언
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// paramMap에서 page, pageSize
		int board_no = paramMap.get("board_no");
		int page = paramMap.get("page");
		int pageSize = paramMap.get("pageSize");
		
		// 전체 게시글 갯수
		int totalCnt = postsDao.getCountPost(board_no);
		resultMap.put("totalCnt", totalCnt);
		
		// page에 맞는 게시글 정보
		List<PostsVO> postPageList = postsDao.getListPost(paramMap);
		resultMap.put("postPageList", postPageList);
		
		// page nav
		String nav = pageNav(totalCnt, page, pageSize, board_no);
		resultMap.put("nav", nav);
		
		return resultMap;
	}

	/**
	* Method : getPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 정보 조회
	*/
	@Override
	public PostsVO getPost(int post_no) {
		return postsDao.getPost(post_no);
	}

	/**
	 * Method : insertPost
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC04
	 * 변경이력 :
	 * @param postsVo
	 * @return
	 * Method 설명 : 게시글 등록
	 */
	@Override
	public int insertPost(PostsVO postsVo) {
		return postsDao.insertPost(postsVo);
	}
	
	/**
	* Method : updatePost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updatePost(PostsVO postsVo) {
		return postsDao.updatePost(postsVo);
	}

	/**
	* Method : deletePost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 삭제 - update
	*/
	@Override
	public int deletePost(int post_no) {
		return postsDao.deletePost(post_no);
	}
	
	private String pageNav(int totalCnt, int page, int pageSize, int board_no){
		
		String navStr = "";
		
		// 최대 페이지 계산
		int maxPage = totalCnt%pageSize == 0 ? totalCnt/pageSize : totalCnt/pageSize+1;
		int prePage = page == 1 ? 1 : page-1;
		int nextPage = page == maxPage ? maxPage : page+1;
		
		// 페이지네이션
		navStr = "<nav><ul class=\"pagination\">";
		
		// 첫 페이지로
		navStr += "<li>"
				+ "<a href=\"/board/postList?board_no="+board_no+"\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&laquo;</span></a></li>";
		
		// 이전으로
		navStr += "<li>"
				+ "<a href=\"/board/postList?board_no="+board_no+"&page="+prePage+"\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&lsaquo;</span></a></li>";
		
		// 페이지
		for (int i = 1; i <= maxPage; i++) {
			String activeClass = "";
			if (i==page) {
				activeClass = "class=\"active\"";
			}
			
			navStr += "<li "+activeClass+"><a href=\"/board/postList?board_no="+board_no+"&page="+i+"\">"+i+"</a></li>";
		}
		
		// 다음으로
		navStr += "<li>"
				+ "<a href=\"/board/postList?board_no="+board_no+"&page="+nextPage+"\" aria-label=\"Next\">"
				+ "<span aria-hidden=\"true\">&rsaquo;</span></a></li>";
				
		// 마지막 페이지로
		navStr += "<li>"
				+ "<a href=\"/board/postList?board_no="+board_no+"&page="+maxPage+"\" aria-label=\"Next\">"
				+ "<span aria-hidden=\"true\">&raquo;</span></a></li>"
				+ "</ul></nav>";
		
		
		return navStr;
	}

	/**
	* Method : insertReplyPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 답글 등록
	*/
	@Override
	public int insertReplyPost(PostsVO postsVo) {
		return postsDao.insertReplyPost(postsVo);
	}

	@Override
	public PostsVO getPostVo(PostsVO postsVo) {
		return postsDao.getPostVo(postsVo);
	}

}
