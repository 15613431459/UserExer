/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:05:55   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.suixingpay.bean.Role;
import com.suixingpay.bean.User;
import com.suixingpay.mapper.UserMapper;
import com.suixingpay.service.PermissionService;
import com.suixingpay.service.RoleService;
import com.suixingpay.service.impl.UserServiceimp;
import com.suixingpay.vo.UserVo;

import net.minidev.json.JSONArray;

/**  
 * TODO
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:05:55
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:05:55
 */
/***
 * 
 * DoAll
 * @author: wanghanyi[wang_hy@suixingpay.com]
 * @date: 2017年3月22日 下午1:04:36
 * @version: V1.0
 * @review: wanghanyi[wang_hy@suixingpay.com]/2017年3月22日 下午1:04:36
 */
@Controller
@RequestMapping(value="/user")
public class UserController{
	@Autowired
	UserServiceimp userservice;
	@Autowired
	RoleService roleservice;
	@Autowired
	PermissionService permissionService;

	/**      
	 * TODO 
	 * @param id
	 * @return
	 * @see com.suixingpay.service.UserService#delete(java.lang.Long)
	 */ 
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int id) {
		userservice.delete(id);
		return "redirect:/user/findAll";
	}

	/**      
	 * TODO 
	 * @param user
	 * @return
	 * @see com.suixingpay.service.UserService#insert(com.suixingpay.vo.UserVo)
	 */ 
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(UserVo user) {
		userservice.insert(user);
		return "redirect:/user/findAll";
	}

	/**      
	 * 修改
	 * @param uservo
	 * @return
	 * @see com.suixingpay.service.UserService#update(com.suixingpay.vo.UserVo)
	 */ 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(UserVo uservo) {
		userservice.update(uservo);
		return "redirect:/user/findAll";
	}
	/**
	 *
	 * 跳转到更新页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/toUpdate",method = RequestMethod.GET)
	public String toUpdate(Model model,int id){
		model.addAttribute("user", userservice.findById(id));
		model.addAttribute("rolelist", roleservice.findAllRole());
		return "updateuser";
	}
	/**      
	 * TODO 
	 * @return
	 * @see com.suixingpay.service.UserService#queryAll()
	 */ 
	//查询所有的用户信息。
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String queryAll(Model model) {
		List<UserVo> userlist = userservice.findAll();
		model.addAttribute("userVoList", userlist);
		return "adminindex";
	}
   
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String login(Model model,String loginName,String password,HttpSession session){
	    
	    UserVo userVo = userservice.findUserByLoginNameAndPassword(loginName, password);
	    
	    if(userVo == null){
	        model.addAttribute("message", "用户名或者密码错误");
	        return "index";
	    }

	    userVo.setRoleList(roleservice.findRoleByUserId(userVo.getId()));
	    List<Role> roleList = userVo.getRoleList();
	    List<Integer> list = new ArrayList<>();
	    
	    for (Iterator<Role> iterator = roleList.iterator(); iterator.hasNext();) {
            Role role = iterator.next();
            list.add(role.getId());
        }
	    userVo.setPermissionList(permissionService.findPermissionByRoleId(list));
	    session.setAttribute("userVo", userVo);
	    
	    for (Role role : roleList) {
	     
            if(role.getName().equals("administrator")){
                //判断该用户是不是管理员
                return "redirect:/user/findAll";
            }
        }
	    return "userIndex";//普通用户界面
	}
	
	//跳转到添加页面
	@RequestMapping(value="/addUser")
	public String insertPage(Model model){
		model.addAttribute("rolelist", roleservice.findAllRole());
		return "adduser";

	}
	//userName是loginname
	@ResponseBody
    @RequestMapping("/ajaxCheckUserName")
    public String ajaxCheckUserName(String userName){
          List<User> userList = userservice.getUserByName(userName);
          String message="false";
          if(userList!=null && userList.size()!=0){
              message="true";
          }
          Gson gson=new Gson();
          JsonElement jsonTree = gson.toJsonTree(message);
           String json = gson.toJson(jsonTree);
          return json;          
    }


}
