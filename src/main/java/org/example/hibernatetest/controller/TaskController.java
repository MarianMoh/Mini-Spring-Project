package org.example.hibernatetest.controller;

import org.example.hibernatetest.model.Task;
import org.example.hibernatetest.service.TaskService;
import org.example.hibernatetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/{user_id}")
    public String showTasks(@PathVariable("user_id") long userId, Model model) {
        model.addAttribute("tasks", taskService.getAllByUserId(userId));
        model.addAttribute("user", userService.readById(userId));
        return "user-tasks";
    }

    @GetMapping("/create/{user_id}")
    public String create(@PathVariable("user_id") long userId, Model model) {
        model.addAttribute("user_id", userId);
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping("/create/{user_id}")
    public String create(@PathVariable("user_id") long userId,
                         @Valid @ModelAttribute("task") Task task) {
        task.setUser(userService.readById(userId));
        taskService.create(task);
        return "redirect:/tasks/" + userId;
    }

    @GetMapping("/update/{task_id}/users/{user_id}")
    public String update(@PathVariable("task_id") long taskId,
                         @PathVariable("user_id") long userId,
                         Model model) {
        model.addAttribute("task", taskService.readById(taskId));
        model.addAttribute("user_id", userId);
        return "update-task";
    }

    @PostMapping("/update/{task_id}/users/{user_id}")
    public String update(@Valid @ModelAttribute("task") Task task,
                         @PathVariable("task_id") long taskId,
                         @PathVariable("user_id") long userId) {
        task.setId(taskId);
        task.setUser(userService.readById(userId));
        taskService.update(task);
        return "redirect:/tasks/" + userId;
    }

    @GetMapping("/delete/{task_id}/users/{user_id}")
    public String delete(@PathVariable("task_id") long taskId,
                         @PathVariable("user_id") long userId) {
        taskService.delete(taskId);
        return "redirect:/tasks/" + userId;
    }
}
