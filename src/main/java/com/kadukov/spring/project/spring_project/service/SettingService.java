package com.kadukov.spring.project.spring_project.service;

import com.kadukov.spring.project.spring_project.entity.Setting;
import com.kadukov.spring.project.spring_project.entity.User;


public interface SettingService {
    public void saveSetting(Setting setting);

    public Setting getSetting(String name);

}