package com.zergatstage.gbsprings03.controllers;

import com.zergatstage.gbsprings03.model.NoItemFoundException;
import com.zergatstage.gbsprings03.model.Task;
import com.zergatstage.gbsprings03.services.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") UUID id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") UUID uuid, @RequestBody Task task){
        return taskService.updateTask(uuid, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") UUID uuid){
        taskService.deleteTask(uuid);
    }

    @ExceptionHandler(NoItemFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(NoItemFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
     }

}
