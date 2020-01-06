package com.liyan.vueapi.service;

import com.liyan.vueapi.pojo.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    List<Menu> findMenu();
}
