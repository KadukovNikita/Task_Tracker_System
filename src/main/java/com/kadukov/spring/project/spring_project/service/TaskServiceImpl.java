package com.kadukov.spring.project.spring_project.service;


import com.kadukov.spring.project.spring_project.dao.TaskDAO;
import com.kadukov.spring.project.spring_project.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDAO taskDAO;

    @Transactional
    @Override
    public List<Task> getTasks() {
        return taskDAO.getTasks();
    }

    @Transactional
    @Override
    public void saveTask(Task task) {
        taskDAO.saveTask(task);
    }


    @Transactional
    @Override
    public Task getTask(int id) {
        return taskDAO.getTask(id);
    }

    @Transactional
    @Override
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
