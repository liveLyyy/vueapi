package com.liyan.vueapi.controller;

import com.liyan.vueapi.enums.ResultCode;
import com.liyan.vueapi.pojo.Menu;
import com.liyan.vueapi.result.MenuTree;
import com.liyan.vueapi.result.Result;
import com.liyan.vueapi.service.Impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private MenuServiceImpl menuService;

    /*
    侧边栏显示查询
     */
    @GetMapping("/sys/menu")
    public Result getMenu() {
        List<Menu> list = menuService.findMenu();
        MenuTree menuTree = new MenuTree(list);
        list = menuTree.builTree();
        if (list != null) {
            return Result.success(list);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }
    /*
    查询所有菜单
     */
    @GetMapping("/sys/right")
    public Result getMenus() {
        List<Menu> list = menuService.findMenu();
        if (list != null) {
            return Result.success(list);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }
}
