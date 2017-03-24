/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:06:44   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suixingpay.bean.Permission;
import com.suixingpay.service.PermissionService;

/**  
 * TODO
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:06:44
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:06:44
 */
@Controller
@RequestMapping(value="/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    
    @RequestMapping(value="/findAllPermission")
    //显示所有权限
    public ModelAndView findAllPermission() {
        ModelAndView mav = new ModelAndView("allPermission");
        List<Permission> list = permissionService.findAllPermission();
        mav.addObject("permissions",list);
        return mav;
    }
    //跳转到新增权限页面
    @RequestMapping(value="/addPermission")
    public String addpermission() {
        return "addPermission";
    }
    //新增权限
    @RequestMapping(value="/insertPermission")
    public String insertPermission(Permission permission) {
        String code = UUID.randomUUID().toString();
        permission.setCode(code);
        permissionService.insertPermission(permission);
        return "redirect:/permission/findAllPermission";
    }
    //删除权限
    @RequestMapping(value="/deletePermission")
    public String deletePermission(int id) {
        permissionService.deletePermission(id);
        return "redirect:/permission/findAllPermission";
    }
    //跳转到修改权限页面
    @RequestMapping(value="/toUpdatePermission")
    public ModelAndView toUpdatePermission(int id) {
        ModelAndView mav = new ModelAndView("updatePermission");
        Permission permission = permissionService.findPermissionById(id);
        mav.addObject("permission",permission);
        return mav;
    }
    //修改权限
    @RequestMapping(value="/updatePermission")
    public String updatePermission(Permission permission) {
        permissionService.updatePermission(permission);
        return "redirect:/permission/findAllPermission";
    }
}
