/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:07:53   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.suixingpay.bean.Permission;

/**  
 * TODO
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:07:53
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:07:53
 */
@Mapper
public interface PermissionMapper {

    /**   
     * TODO
     * @return 
     */  
    List<Permission> findAllPermission();

    /**   
     * TODO
     * @return 
     */  
    int insertPermission(Permission permission);

    List<Permission> findPermissionByRoleId(@Param("roleIds")List<Integer> roleIds);

    /**   
     * TODO
     * @param id 
     */  
    void deletePermission(@Param("id")int id);

    /**   
     * TODO
     * @param id 
     */  
    void deleteRolePermission(@Param("id")int id);

    /**   
     * TODO
     * @param id
     * @return 
     */  
    Permission findPermissionById(@Param("id")int id);

    /**   
     * TODO
     * @param permission 
     */  
    void updatePermission(Permission permission);

    /**   
     * TODO
     * @param roleId
     * @return 
     */  
    List<Permission> findPermissionByOneRoleId(@Param("role_id")int roleId);
}
