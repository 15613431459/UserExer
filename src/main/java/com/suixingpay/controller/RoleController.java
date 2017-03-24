/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午12:06:31   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suixingpay.bean.Permission;
import com.suixingpay.bean.Role;
import com.suixingpay.service.PermissionService;
import com.suixingpay.service.RoleService;
import com.suixingpay.vo.RoleVo;

/**
 * 表现层角色Controller实现
 * 
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午12:06:31
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午12:06:31
 */
@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有用户角色
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAllRole", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        List<Role> roles = roleService.findAllRole();
        List<RoleVo> roleVos = new ArrayList<RoleVo>();
        Iterator<Role> iterator = roles.iterator();
        while(iterator.hasNext()){
            RoleVo roleVo = new RoleVo();
            Role role = iterator.next();
            List<Permission> permissions = permissionService.findPermissionByOneRoleId(role.getId());
            roleVo.setRole(role);
            roleVo.setPermissions(permissions);
            roleVos.add(roleVo);
        }
        model.addAttribute("roleVos", roleVos);
        return "allRole";
    }

    /**
     * 显示用户角色添加页面
     * 
     * @return
     */
    @RequestMapping("/showAddRole")
    public String showAddRole(Model model) {
        List<Permission> permissions = permissionService.findAllPermission();
        model.addAttribute("permissions", permissions);
        return "addRole";
    }

    /**
     * 添加用户角色
     * 
     * @param roleVo
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(RoleVo roleVo) {
        roleService.addRole(roleVo.getRole(), roleVo.getPermissionIds());
        return "redirect:/roles/findAllRole";
    }

    /**
     * 删除用户角色
     * 
     * @return
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(int id) {
        roleService.deleteRole(id);
        return "redirect:/roles/findAllRole";
    }

    /**
     * 显示修改用户角色页面
     * 
     * @return
     */
    @RequestMapping("/showRole")
    public String showRole(Model model, int id) {
        Role role = roleService.findRoleById(id);
        List<Permission> allPermission = permissionService.findAllPermission();
        RoleVo roleVo = new RoleVo();
        roleVo.setAllPermission(allPermission);
        roleVo.setRole(role);
        model.addAttribute("roleVo", roleVo);
        return "showRole";
    }

    /**
     * 修改角色
     * 
     * @param roleVo
     * @return
     */

    @RequestMapping("/updateRole")
    public String updateRole(RoleVo roleVo) {
        roleService.updateRole(roleVo.getRole(), roleVo.getPermissionIds());
        return "redirect:/roles/findAllRole";
    }

}
