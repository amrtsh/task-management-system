package com.example.tmsystem.controller;

import com.example.tmsystem.dto.TaskDto;
import com.example.tmsystem.dto.TaskToCreateDto;
import com.example.tmsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/getAllByAssignedToId/{userId}")
    public ResponseEntity<List<TaskDto>> getAllTasksByAssignedToId(@PathVariable Integer userId) {
        List<TaskDto> taskDtoList = taskService.findAllTasksByAssignedToId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(taskDtoList);
    }

    @GetMapping("/getById/{taskId}")
    public ResponseEntity<TaskDto> getById(@PathVariable Integer taskId) {
        TaskDto task = taskService.getTaskById(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TaskDto>> getAll() {
        List<TaskDto> taskDtoList = taskService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(taskDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskToCreateDto taskToCreateDto) {
        TaskDto task = taskService.createTask(taskToCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/update")
    public ResponseEntity<TaskDto> update(@RequestBody TaskDto taskDto) {
        TaskDto task = taskService.updateTask(taskDto);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Integer taskId) {
        taskService.deleteTaskById(taskId);
    }
}
