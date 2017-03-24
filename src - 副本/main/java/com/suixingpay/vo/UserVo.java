/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:35:22   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.vo;

import java.util.List;

import com.suixingpay.bean.Permission;
import com.suixingpay.bean.Role;
import com.suixingpay.bean.User;

/**  
 * TODO
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:35:22
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:35:22
 */
public class UserVo extends User {
    /**   
     * @Fields serialVersionUID: TODO
     */ 
    private static final long serialVersionUID = 1L;
    private List<Role> roleList;
    private List<Permission> permissionList;
    public List<Role> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    public List<Permission> getPermissionList() {
        return permissionList;
    }
    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
    
}
