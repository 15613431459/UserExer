/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:08:14   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixingpay.bean.Permission;
import com.suixingpay.bean.Role;
import com.suixingpay.bean.User;
import com.suixingpay.mapper.PermissionMapper;
import com.suixingpay.mapper.RoleMapper;
import com.suixingpay.mapper.UserMapper;
import com.suixingpay.service.UserService;
import com.suixingpay.vo.UserVo;

/**  
 * TODO
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:08:14
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:08:14
 */
@Service
public class UserServiceimp implements UserService{
	@Autowired
	RoleMapper rolemapper;
	@Autowired
	UserMapper usermapper;
	@Autowired
	PermissionMapper permissionmapper;
	
	/**
	 * success
	 * 添加user的，需要2步，一个是插入user表另一个是插入user角色表。
	 * @param user
	 * @return
	 */
	public int insert(UserVo user){	
		//插入
		usermapper.insert(user);
		//插入后获取userid，放到user里
		user.setId(usermapper.findByName(user.getLoginName()).get(0).getId());
		//设置role默认是 
		
		for (Role role  : user.getRoleList()) {
			usermapper.insertUserRole(user.getId(),role.getId());
		}
		return 1;
	}
	/**
	 * 
	 *  更新，需要两步，第一步是先插入
	 * @param user
	 * @return
	 * @see com.suixingpay.service.UserService#update(com.suixingpay.vo.UserVo)
	 */
	public int update(UserVo user){
		usermapper.update(user);
		usermapper.deleteUserRole(user.getId());
		for (Role role  : user.getRoleList()) {
			usermapper.insertUserRole(user.getId(),role.getId());
		}
		return 1;
	}
	/**
	 * success
	 * TODO 
	 * @return
	 * @see com.suixingpay.service.UserService#findAll()
	 */
	public List<UserVo> findAll(){
		List<UserVo> userlist =	usermapper.findAll();
		
	
		//遍历得到了uservo列表，向其中添加角色列表和权限列表
		for (int i = 0;i<userlist.size();i++){
			//添加角色列表
			List<Role> roleList = rolemapper.findRoleByUserId(userlist.get(i).getId());
			userlist.get(i).setRoleList(roleList);
			
			//获取权限列表
			HashSet<Permission> permissionset = new HashSet<Permission>();
			//根据角色列表获取角色id列表
			List<Integer> roleIdList  = new ArrayList<Integer>(); 
			for (Role role : roleList) {
				roleIdList.add(role.getId());
			}
			//通过roleid列表获取权限列表。
			userlist.get(i).setPermissionList(permissionmapper.findPermissionByRoleId(roleIdList));
			
			//userlist.get(i).getPermissionList().addAll(permissionset);
		}
		
		return userlist;
	}
	/**   
	 * TODO
	 * @param userName
	 * @return 
	 */  
	public List<User> getUserByName(String loginName) {
		// TODO Auto-generated method stub
		return usermapper.findByName( loginName);
	}
	/**      
	 * TODO 
	 * @param loginName
	 * @param password
	 * @return
	 * @see com.suixingpay.service.UserService#findUserByLoginNameAndPassword(java.lang.String, java.lang.String)
	 */ 
	@Override
	public UserVo findUserByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return usermapper.findUserByLoginNameAndPassword(loginName, password);
	}
	/**      
	 *
	 * @param id
	 * @return
	 * @see com.suixingpay.service.UserService#delete(java.lang.Long)
	 */ 
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		usermapper.deleteUserRole(id);
		return usermapper.delete(id);
	}
	public User findById(int id){
		return usermapper.findById(id);
	}
	

	}
