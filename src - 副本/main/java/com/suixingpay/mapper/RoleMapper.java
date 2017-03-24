/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:07:26   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.suixingpay.bean.Role;

/**  
 * 用户角色持久层接口
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:07:26
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:07:26
 */
@Mapper
public interface RoleMapper {

    /**
     * 
     * 查询所有用户角色列表
     * @return 用户角色列表
     */
    List<Role> findAllRole();
    /**
     * 
     * 根据用户id查询用户角色
     * @param userId
     * @return 用户角色列表
     */
    List<Role> findRoleByUserId(@Param("userId") int userId);
    /**   
     * 根据id查询用户角色
     * @param id
     * @return 
     */  
    Role findRoleById(@Param("id") int id);
    /**   
     * 删除用户角色
     * @param id 
     */  
    void deleteRole(@Param("id") int id);
    /**
     * 根据用户角色id删除角色权限中间表记录
     * TODO
     * @param id
     */
    void deleteRolePermissionByRoleId(@Param("id") int id);
    /**   
     * 添加用户角色
     * @param role 
     */  
    Integer addRole(Role role);
    /**   
     * 向角色权限中间表添加记录
     * @param id
     * @param i 
     */  
    void addRolePermission(@Param("roleId")int roleId, @Param("permissionId")int permissionId);
    /**   
     * 修改角色
     * @param role 
     */  
    void updateRole(Role role);
}
