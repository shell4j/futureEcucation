package cn.edu.bnu;

import org.apache.catalina.connector.Request;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@EnableAutoConfiguration
public class searchController {
	@RequestMapping(value = {"/","/index"})
	public String index(){
		return "index";
	}
	@RequestMapping(value = "/search")
	public String  processForm(@RequestParam("q") String query,
			@RequestParam("b") String book,
			RedirectAttributes ra) {
		System.out.println(query);
		System.out.println(book);
		ra.addAttribute("q",query);
		ra.addAttribute("b",book);
		return "redirect:/result";
	}
	@RequestMapping(value = "/result")
	@ResponseBody
	public ModelAndView  result(@RequestParam("q") String query,
			@RequestParam("b") String book,ModelMap mp) {
		//分词等操作
		mp.addAttribute("query", query);
		mp.addAttribute("book", book);
		System.out.println(query+"\t"+book);
		ModelAndView mv=new ModelAndView("result",mp);
		return mv;
	}
	
}
