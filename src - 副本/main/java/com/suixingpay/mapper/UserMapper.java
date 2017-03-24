/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:07:11   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.suixingpay.bean.Role;
import com.suixingpay.bean.User;
import com.suixingpay.vo.UserVo;


/**
 * 
 * TODO
 * @author: wanghanyi[wang_hy@suixingpay.com]
 * @date: 2017年3月22日 下午4:55:17
 * @version: V1.0
 * @review: wanghanyi[wang_hy@suixingpay.com]/2017年3月22日 下午4:55:17
 */
@Mapper
public interface UserMapper {
	/**
	 * 
	 * success
	 * @param user
	 * @return
	 */
	public int insert(UserVo user);
	/**
	 * 
	 * success
	 * @param user
	 * @return
	 */
	public int update(UserVo user);

	

	/***
	 * success
	 * 插入角色用户信息
	 * @param rolelist
	 * @return
	 */
	public int insertUserRole(int userid,int roleid);
	/**
	 * 根据id删除user表中的信息
	 * success
	 * @param id
	 * @return
	 */
	public int  delete(int id);
	/***
	 * success
	 * 删除角色用户中间表中的，某u_id用户的所有的角色信息
	 * @param id
	 * @return
	 */
	public int deleteUserRole(int id);
	/**
	 * 
	 * 通过用户名和密码查询信息
	 * @param loginName
	 * @param password
	 * @return
	 */
	public int insertUserRole(List<Role> rolelist);
	
	public UserVo findUserByLoginNameAndPassword(@Param("loginName")String loginName,@Param("password")String password);

	/**   
	 * success
	 * 通过登录名查询
	 * @param loginName
	 * @return 
	 */  
	public List<User> findByName(String loginName);
	/**
	 * success
	 * 查询所有信息
	 * @return
	 */
	public List<UserVo> findAll(); 
	/**
	 * 根据id查询
	 */
	public User findById(int id);
}
