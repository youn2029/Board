package kr.or.ddit.posts.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.posts.model.PostsVO;

public class PostsDao implements PostsDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : getListPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param pageMap
	* @return
	* Method 설명 : 게시판의 게시글 페이지별 조회
	*/
	@Override
	public List<PostsVO> getListPost(Map<String, Integer> paramMap) {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<PostsVO> postList = session.selectList("posts.getListPost", paramMap);
		session.close();
		
		return postList;
	}	

	/**
	* Method : getCountPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC04
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판의 게시글 전체 갯수 조회
	*/
	@Override
	public int getCountPost(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int totalCnt = session.selectOne("posts.getCountPost", board_no);
		session.close();
		
		return totalCnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		PostsVO postsVo = session.selectOne("posts.getPost", post_no);
		session.close();
		
		return postsVo;
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
		
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.insert("posts.insertPost", postsVo);
		session.commit();
		session.close();
		
		return resultCnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("posts.updatePost", postsVo);
		session.commit();
		session.close();
		
		return resultCnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.update("posts.deletePost", post_no);
		session.commit();
		session.close();
		
		return resultCnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		int resultCnt = session.insert("posts.insertReplyPost", postsVo);
		session.commit();
		session.close();
		return resultCnt;
	}

	/**
	* Method : getPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC04
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 게시글 정보 조회
	*/
	@Override
	public PostsVO getPostVo(PostsVO postsVo) {
		SqlSession session = sqlSessionFactory.openSession();
		PostsVO postVo = session.selectOne("posts.getPostVo", postsVo);
		session.close();
		
		return postVo;
	}
	
	
}
