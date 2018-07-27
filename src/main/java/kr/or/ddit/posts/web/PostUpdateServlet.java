package kr.or.ddit.posts.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.posts.model.AttachedFileVO;
import kr.or.ddit.posts.model.PostsVO;
import kr.or.ddit.posts.service.AttachedFileService;
import kr.or.ddit.posts.service.AttachedFileServiceInf;
import kr.or.ddit.posts.service.PostsService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/postUpdate")
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 수정 화면으로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// 게시글 정보
		PostsServiceInf postsService = new PostsService();
		PostsVO postVo = postsService.getPost(post_no);
		
		// 첨부파일 정보
		AttachedFileServiceInf fileService = new AttachedFileService();
		List<AttachedFileVO> fileList = fileService.getFileList(post_no);
		
		// request에 저장
		request.setAttribute("postVo", postVo);
		request.setAttribute("fileList", fileList);
		
		// postUpdate.jsp로 위임
		request.getRequestDispatcher("/posts/postUpdate.jsp").forward(request, response);
	}
	
	// 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 파라미터
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		
		// postsVo 객체
		PostsVO postsVo = new PostsVO();
		postsVo.setPost_no(post_no);
		postsVo.setPost_content(post_content);
		postsVo.setPost_title(post_title);
		
		// update
		PostsServiceInf postsService = new PostsService();
		int resultCnt = postsService.updatePost(postsVo);		
		
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
					System.out.println(file_name);
					String file_path = FileUtil.fileUploadPath;
					String file_upload = UUID.randomUUID().toString();
					
					AttachedFileVO fileVo = new AttachedFileVO();
					fileVo.setFile_name(file_name);
					fileVo.setFile_path(file_path);
					fileVo.setFile_upload(file_upload);
					fileVo.setPost_no(post_no);					
					
					// 첨부파일 insert
					resultCnt = fileService.insertFile(fileVo);	
					
					// 물리적 파일명은 임의로 적용
					part.write(file_path + File.separator + file_upload);
					part.delete();	
					
				}					
			}
		}
		
		
		// postUpdate로 취임
		response.sendRedirect(request.getContextPath()+"/postDetail?post_no="+post_no);
	}

}
