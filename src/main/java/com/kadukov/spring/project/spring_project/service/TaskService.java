package com.kadukov.spring.project.spring_project.service;




import com.kadukov.spring.project.spring_project.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getTasks();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}