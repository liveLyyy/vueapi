package com.liyan.vueapi.service.Impl;

import com.liyan.vueapi.mapper.MenuMapper;
import com.liyan.vueapi.pojo.Menu;
import com.liyan.vueapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findMenu() {
        return menuMapper.findMenu();
    }
}
