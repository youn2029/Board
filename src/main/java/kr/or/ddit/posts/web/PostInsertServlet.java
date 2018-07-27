package kr.or.ddit.posts.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.posts.web.FileUtil;
import kr.or.ddit.posts.model.AttachedFileVO;
import kr.or.ddit.posts.model.PostsVO;
import kr.or.ddit.posts.service.AttachedFileService;
import kr.or.ddit.posts.service.AttachedFileServiceInf;
import kr.or.ddit.posts.service.PostsService;
import kr.or.ddit.posts.service.PostsServiceInf;
import kr.or.ddit.student.model.StudentVO;

/**
 * Servlet implementation class PostInsertServlet
 */
@WebServlet("/postInsert")
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
public class PostInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	// 등록 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 : 게시판 번호
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		// request에 저장
		request.setAttribute("board_no", board_no);
		
		// postInsert.jsp로 위임
		request.getRequestDispatcher("/posts/postInsert.jsp").forward(request, response);
		
		
	}
    
	// DB에 게시글 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// Session에서 회원정보
		HttpSession session = request.getSession();
		StudentVO stdVo = (StudentVO) session.getAttribute("stdVo");
		
		// 파라미터
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");				
		
		// post객체
		PostsVO postsVo = new PostsVO();
		postsVo.setPost_title(post_title);			// 제목
		postsVo.setPost_content(post_content);		// 내용
		postsVo.setId(stdVo.getId());				// 학생번호
		postsVo.setStd_id(stdVo.getStd_id());		// 학생아이디
		postsVo.setBoard_no(board_no);				// 게시판번호
		
		// 게시글 insert
		PostsServiceInf postsService = new PostsService();
		int resultCnt = postsService.insertPost(postsVo);				
		
		if (resultCnt == 1) {
			
			// 등록 된 postVo 정보
			PostsVO postVo = postsService.getPostVo(postsVo);
			request.setAttribute("postVo", postVo);
			
			// 파라미터를 모두 저장
			Collection<Part> parts = request.getParts();		
			
			// 첨부파일 service
			AttachedFileServiceInf fileService = new AttachedFileService();
			
			for (Part part : parts) {
				
				if(part.getSize() > 0){
					// file 이름에 대한 정보를 획득 : getHeader("Content-Disposition");
					// form-data; name="uploadFile"; filename="icebear.jpg"
					String contentDisposition = part.getHeader("Content-Disposition");
					
					// DB에 저장될 값
					String file_name = FileUtil.getFileName(contentDisposition);
					
					if (!file_name.equals("")) {
						// file_path, file_upload
						String file_path = FileUtil.fileUploadPath;
						String file_upload = UUID.randomUUID().toString();
						
						// fileVo
						AttachedFileVO fileVo = new AttachedFileVO();
						fileVo.setFile_name(file_name);
						fileVo.setFile_path(file_path);
						fileVo.setFile_upload(file_upload);
						fileVo.setPost_no(postVo.getPost_no());					
						
						// 첨부파일 insert
						resultCnt = fileService.insertFile(fileVo);	
						
						// 물리적 파일명은 임의로 적용
						part.write(file_path + File.separator + file_upload);
						part.delete();						
						
						if (resultCnt == 0) {
							response.sendRedirect(request.getContextPath()+"/postList?board_no="+board_no);							
						}
						
					}					
				}
			}
			
			// 첨부파일 조회
			List<AttachedFileVO> fileList = fileService.getFileList(postVo.getPost_no());
			request.setAttribute("fileList", fileList);
			
			// postDeDetail.jsp로 위임
			request.getRequestDispatcher("/posts/postDetail.jsp").forward(request, response);
			
		}else{
			response.sendRedirect(request.getContextPath()+"/postList?board_no="+board_no);							
			
		}
	}

}
