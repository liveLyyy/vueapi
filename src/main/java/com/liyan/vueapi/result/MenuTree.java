package com.liyan.vueapi.result;

import com.liyan.vueapi.pojo.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {
    private List<Menu> menuList = new ArrayList<>();

    public MenuTree(List<Menu> menuList) {
        this.menuList = menuList;
    }

    //建立树形结构
    public List<Menu> builTree() {
        List<Menu> treeList = new ArrayList<>();
        for (Menu menuNode : getRooeNode()) {
            menuNode = buildChilTree(menuNode);
            treeList.add(menuNode);
        }
        return treeList;
    }

    //递归，建立子树形结构
    private Menu buildChilTree(Menu pNode) {
        List<Menu> chilMenus = new ArrayList<Menu>();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentId().equals(pNode.getId())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
       pNode.setChildren(chilMenus);
        return pNode;
    }

    //获取根节点
    private List<Menu> getRooeNode() {
        List<Menu> rootMenuLists = new ArrayList<Menu>();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

}
