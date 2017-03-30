package cn.edu.bnu;

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
	public String index(String keyword,ModelMap map){
		//map.addAttribute("name","12345");
		return "index";
	}
	@RequestMapping(value = "/search")
	public String  processForm(@RequestParam("q") String query,@RequestParam("q") String book,@RequestParam("q") String course,@RequestParam("q") String knowledge,RedirectAttributes ra) {
		//分词等操作
		System.out.println(query);
		System.out.println(book);
		System.out.println(course);
		System.out.println(knowledge);
		ra.addAttribute("q",query);
		return "redirect:/result";
	}
	@RequestMapping(value = "/result")
	@ResponseBody
	public ModelAndView  result(@RequestParam("q") String query,ModelMap mp) {
		//分词等操作
		mp.addAttribute("query", query);
		System.out.println(query);
		ModelAndView mv=new ModelAndView("result",mp);
		return mv;
	}
	
}
