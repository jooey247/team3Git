package cse.test;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class MainController {
	@Autowired
	private UserReposit userRepository;

	@RequestMapping(value="/login/{id}")
	public @ResponseBody User login(@PathVariable String id)
	{
		if(userRepository.findOne(id) != null)
		{
			System.out.println("==============login success==============");			
		}
		else
		{
			System.out.println("==============login fail==============");
		}
		return userRepository.findOne(id);
			
	}
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public String fileupload(Model model, MultipartRequest multipartRequest) throws IOException
	{

		  MultipartFile file = multipartRequest.getFile("upload");   //뷰에서 form으로 넘어올 때 name에 적어준 이름입니다.
		  Calendar cal = Calendar.getInstance();
		  String fileName = file.getOriginalFilename();
		  String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		  String replaceName = cal.getTimeInMillis() + fileType;  //파일 이름의 중복을 막기 위해서 이름을 재설정합니다.
	  
		  String path = "C:\filetest";   //제 바탕화면의 upload 폴더라는 경로입니다. 자신의 경로를 쓰세요.
		  FileUpload.fileUpload(file, path, replaceName);
		  return "redirect:/";
	}
}
