package org.example.hibernatetest.service.impl;

import org.example.hibernatetest.model.Task;
import org.example.hibernatetest.repository.TaskRepository;
import org.example.hibernatetest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final static String ENTITY_NOT_FOUND = "Task wasn't found by id %s";

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task readById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ENTITY_NOT_FOUND, id)));
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        readById(task.getId());
        return taskRepository.save(task);
    }

    @Override
    public void delete(long id) {
        taskRepository.delete(readById(id));
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllByUserId(long id) {
        return taskRepository.findAll().stream()
                .filter((task) -> task.getUser().getId() == id)
                .collect(Collectors.toList());
    }
}
