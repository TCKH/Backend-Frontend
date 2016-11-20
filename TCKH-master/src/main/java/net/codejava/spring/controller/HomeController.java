package net.codejava.spring.controller;

import net.codejava.spring.dao.CommentDAO;
import net.codejava.spring.dao.PostDAO;
import net.codejava.spring.model.Post;
import net.codejava.spring.model.Comment;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private PostDAO postDAO;
	@Autowired
	private CommentDAO commentDAO;
	private static String UPLOAD_LOCATION="F:/Backend-Frontend/tckh-manager-front/app/data/";

	@RequestMapping(value="/ListComment", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Comment> ListComment() throws IOException{
		List<Comment> listComment = commentDAO.list();
		return listComment;
	}
	@RequestMapping(value="/ListArticle", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Post> ListArticle() throws IOException{
		List<Post> listArticle = postDAO.list();
		return listArticle;
	}
	@RequestMapping(value = "/NewArticle", method = RequestMethod.POST)
	public @ResponseBody Boolean newArticle(@RequestBody Post post) {
		postDAO.saveOrUpdate(post);
		return true;
	}
	@RequestMapping(value = "/NewComment", method = RequestMethod.POST)
	public @ResponseBody Boolean NewComment(@RequestBody Comment comment) {
		System.out.println(comment.getFileName());
		commentDAO.saveOrUpdate(comment);
		return true;
	}
	@RequestMapping(value = "/GetArticle", method = RequestMethod.POST)
	public @ResponseBody Post GetArticle(@RequestBody Post post) {
		post = postDAO.get(post.getId());
		return post;
	}
	@RequestMapping(value = "/DeleteArticle", method = RequestMethod.POST)
	public @ResponseBody List<Post> DeleteArticle(@RequestBody Post post) {
		postDAO.delete(post.getId());
		List<Post> listArticle = postDAO.list();
		return listArticle;
	}
	@RequestMapping(value = "/continueFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String continueFileUpload(HttpServletRequest request,
            HttpServletResponse response){
     MultipartHttpServletRequest mRequest;
        try {
            mRequest = (MultipartHttpServletRequest) request;
            mRequest.getParameterMap();
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
            	
                MultipartFile mFile = mRequest.getFile(itr.next());
                FileCopyUtils.copy(mFile.getBytes(), new File(UPLOAD_LOCATION + mFile.getOriginalFilename()));
                String fileName = mFile.getOriginalFilename();
                System.out.println(fileName);
                return fileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
            return "fail";
        }
        return null;
    }

}
