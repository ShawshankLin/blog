package net.shawshank.blog.service.sys;

import javax.annotation.Resource;

import net.shawshank.blog.dao.DaoSupport;
import net.shawshank.blog.entity.sys.User;
import net.shawshank.blog.util.PageData;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	/*
	* 通过id获取数据
	*/
	public PageData findByUiId(PageData pd)throws Exception{
		return (PageData)dao.findForObject("UserMapper.findByUiId", pd);
	}
	
	/*
	* 登录判断
	*/
	public PageData getUserByNameAndPwd(PageData pd)throws Exception{
		return (PageData)dao.findForObject("UserMapper.getUserInfo", pd);
	}
	public User getUserByNameAndPwd(User user)throws Exception{
		return (User)dao.findForObject("UserMapper.getUserInfo1", user);
	}
	
	/*
	* 保存用户
	*/
	public void saveU(PageData pd)throws Exception{
		dao.save("UserMapper.saveU", pd);
	}
	
	public void save(User user)throws Exception{
		dao.save("UserMapper.save", user);
	}
}
