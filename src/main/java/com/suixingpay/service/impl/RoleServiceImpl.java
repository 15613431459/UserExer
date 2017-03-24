/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyanan[wang_yn1@suixingpay.com] 
 * @date: 2017年3月22日 下午1:48:26   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixingpay.bean.Role;
import com.suixingpay.mapper.RoleMapper;
import com.suixingpay.service.RoleService;

/**  
 * 业务层用户角色实现类
 * @author: wangyanan[wang_yn1@suixingpay.com]
 * @date: 2017年3月22日 下午1:48:26
 * @version: V1.0
 * @review: wangyanan[wang_yn1@suixingpay.com]/2017年3月22日 下午1:48:26
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper; 
    
    /**      
     * 查询所有用户角色
     * @return 用户角色列表
     * @see com.suixingpay.service.RoleService#findAllRole()
     */
    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    /**      
     * 根据用户id查询用户角色
     * @param userId
     * @return
     * @see com.suixingpay.service.RoleService#findPermissionByUserId(java.lang.Long)
     */ 
    @Override
    public List<Role> findRoleByUserId(int userId) { 
        return roleMapper.findRoleByUserId(userId);
    }

    /**      
     * 删除用户角色
     * @param id
     * @see com.suixingpay.service.RoleService#deleteRole(int)
     */ 
    @Override
    public void deleteRole(int id) {
        Role role = roleMapper.findRoleById(id);
        if (role == null) {
            throw new RuntimeException("删除的用户角色不存在");
        }
        roleMapper.deleteRolePermissionByRoleId(id);
        roleMapper.deleteRole(id);
    }

    /** 添加用户角色     
     * permissionIds
     * @param role
     * @param permissionIds
     * @see com.suixingpay.service.RoleService#addRole(com.suixingpay.bean.Role, int[])
     */ 
    @Override
    public void addRole(Role role, List<Integer> permissionIds) {
        role.setCode(UUID.randomUUID().toString());
        roleMapper.addRole(role);
        for (Integer permissionId : permissionIds) {
            roleMapper.addRolePermission(role.getId(),permissionId);
        }
    }

    /**      
     * 根据id查询角色
     * @param id
     * @return
     * @see com.suixingpay.service.RoleService#findRoleById(int)
     */ 
    @Override
    public Role findRoleById(int id) {
        return roleMapper.findRoleById(id);
    }

    /**      
     * 修改用户角色
     * @param role
     * @param permissions
     * @see com.suixingpay.service.RoleService#updateRole(com.suixingpay.bean.Role, java.util.List)
     */ 
    @Override
    public void updateRole(Role role, List<Integer> permissions) {
        roleMapper.deleteRolePermissionByRoleId(role.getId());
        for (Integer permissionId : permissions) {
            roleMapper.addRolePermission(role.getId(), permissionId);
        }
        roleMapper.updateRole(role);
    }

}
