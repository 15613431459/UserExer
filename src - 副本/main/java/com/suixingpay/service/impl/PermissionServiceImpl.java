/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: matieli[ma_tl@suixingpay.com] 
 * @date: 2017年3月22日 下午2:14:13   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixingpay.bean.Permission;
import com.suixingpay.mapper.PermissionMapper;
import com.suixingpay.service.PermissionService;

/**  
 * TODO
 * @author: matieli[ma_tl@suixingpay.com]
 * @date: 2017年3月22日 下午2:14:13
 * @version: V1.0
 * @review: matieli[ma_tl@suixingpay.com]/2017年3月22日 下午2:14:13
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    /**      
     * TODO 
     * @return
     * @see com.suixingpay.service.PermissionService#findAllPermission()
     */
    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.findAllPermission();
    }

    /**      
     * TODO 
     * @return
     * @see com.suixingpay.service.PermissionService#insertPermission()
     */
    @Override
    public int insertPermission(Permission permission) {
        return permissionMapper.insertPermission(permission);
    }

    /**      
     * TODO 
     * @param userId
     * @return
     * @see com.suixingpay.service.PermissionService#findPermissionByUserId(int)
     */ 
    @Override
    public List<Permission> findPermissionByRoleId(List<Integer> roleIds) {
        return permissionMapper.findPermissionByRoleId(roleIds);
    }

    /**      
     * TODO 
     * @param id
     * @return
     * @see com.suixingpay.service.PermissionService#deletePermission(int)
     */ 
    @Override
    public void deletePermission(int id) {
        permissionMapper.deletePermission(id);
        permissionMapper.deleteRolePermission(id);
    }

    /**      
     * TODO 
     * @return
     * @see com.suixingpay.service.PermissionService#findPermissionById()
     */ 
    @Override
    public Permission findPermissionById(int id) {
        return permissionMapper.findPermissionById(id);
    }

    /**      
     * TODO 
     * @param permission
     * @see com.suixingpay.service.PermissionService#updatePermission(com.suixingpay.bean.Permission)
     */ 
    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }

    /**      
     * TODO 
     * @param roleId
     * @return
     * @see com.suixingpay.service.PermissionService#findPermissionIdByRoleId(int)
     */ 
    @Override
    public List<Permission> findPermissionByOneRoleId(int roleId) {
        return permissionMapper.findPermissionByOneRoleId(roleId);
    }

}
