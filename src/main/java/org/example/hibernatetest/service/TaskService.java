package org.example.hibernatetest.service;


import org.example.hibernatetest.model.Task;

import java.util.List;

public interface TaskService {
    Task readById(long id);

    Task create(Task task);

    Task update(Task task);

    void delete(long id);

    List<Task> getAll();

    List<Task> getAllByUserId(long id);
}
