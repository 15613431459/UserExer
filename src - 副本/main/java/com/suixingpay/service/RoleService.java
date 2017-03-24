/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:09:09   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.service;

import java.util.List;

import com.suixingpay.bean.Role;

/**  
 * 业务层用户角色接口
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:09:09
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:09:09
 */
public interface RoleService {
    /**
     * 
     * 查询所有用户角色
     * @return 用户角色列表
     */
    List<Role> findAllRole();
    /**
     * 
     * 根据用户id查询用户角色
     * @param userId
     * @return 用户角色列表
     */
    List<Role> findRoleByUserId(int userId);
    /**   
     * 删除用户角色
     * @param id 
     */  
    void deleteRole(int id);
    /**   
     * 添加用户角色，维护角色权限中间表
     * @param role
     * @param permissionIds 
     */  
    void addRole(Role role, List<Integer> permissionIds);
    /**   
     * 根据id查询角色
     * @param id
     * @return 
     */  
    Role findRoleById(int id);
    /**   
     * 修改用户角色
     * @param role
     * @param permissions 
     */  
    void updateRole(Role role, List<Integer> permissions);
}
