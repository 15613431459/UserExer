/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyanan[wang_yn1@suixingpay.com] 
 * @date: 2017年3月22日 下午4:22:20   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.vo;

import java.util.List;

import com.suixingpay.bean.Permission;
import com.suixingpay.bean.Role;

/**
 * 添加用户角色包装类
 * 
 * @author: wangyanan[wang_yn1@suixingpay.com]
 * @date: 2017年3月22日 下午4:22:20
 * @version: V1.0
 * @review: wangyanan[wang_yn1@suixingpay.com]/2017年3月22日 下午4:22:20
 */
public class RoleVo {

    private Role role;
    // 所有权限
    private List<Permission> allPermission;
    // 角色拥有的权限
    private List<Permission> permissions;
    //角色拥有权限的id
    private List<Integer>permissionIds;
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getAllPermission() {
        return allPermission;
    }

    public void setAllPermission(List<Permission> allPermission) {
        this.allPermission = allPermission;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return the permissionIds
     */
    public List<Integer> getPermissionIds() {
        return permissionIds;
    }

    /**
     * @param permissionIds the permissionIds to set
     */
    public void setPermissionIds(List<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }

}
