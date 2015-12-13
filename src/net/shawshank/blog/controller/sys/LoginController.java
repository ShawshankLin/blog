package net.shawshank.blog.controller.sys;

import javax.annotation.Resource;

import net.shawshank.blog.controller.base.BaseController;
import net.shawshank.blog.service.sys.UserService;
import net.shawshank.blog.util.Const;
import net.shawshank.blog.util.PageData;
import net.shawshank.blog.util.Tools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/*
 * 总入口
 */
@Controller
public class LoginController extends BaseController{

	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 访问登录页
	 * @return
	 */
	@RequestMapping(value="/login_toLogin")
	public ModelAndView toLogin()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		mv.setViewName("login");
		mv.addObject("pd",pd);
		return mv;
	}
}
