/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:09:31   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.service;

import java.util.List;

import com.suixingpay.bean.Permission;

/**  
 * 
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:09:31
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:09:31
 */
public interface PermissionService {

    /**   
     * TODO
     * @return 
     */  
    List<Permission> findAllPermission();

    /**   
     * TODO 
     */  
    int insertPermission(Permission permission);
    
    List<Permission> findPermissionByRoleId(List<Integer> roleIds);

    /**   
     * TODO
     * @param id 
     */  
    void deletePermission(int id);

    /**   
     * TODO
     * @return 
     */  
    Permission findPermissionById(int id);

    /**   
     * TODO
     * @param permission 
     */  
    void updatePermission(Permission permission);
    
    List<Permission> findPermissionByOneRoleId(int roleId);

}
