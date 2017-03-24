
package com.suixingpay.service;

import java.util.List;

import com.suixingpay.bean.User;
import com.suixingpay.vo.UserVo;

/**  
 * TODO
 * @author: wanghanyi[wang_hy@suixingpay.com]
 * @date: 2017年3月22日 下午2:16:14
 * @version: V1.0
 * @review: wanghanyi[wang_hy@suixingpay.com]/2017年3月22日 下午2:16:14
 */
public interface UserService {

	List<User> getUserByName(String loginName);
	
	int delete(int id);

	int insert(UserVo user);

	int update(UserVo uservo);

	List<UserVo> findAll();
	
	UserVo findUserByLoginNameAndPassword(String loginName,String password);
	
	User findById(int id);
}

