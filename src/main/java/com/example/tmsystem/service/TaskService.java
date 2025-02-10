package com.example.tmsystem.service;

import com.example.tmsystem.dto.TaskDto;
import com.example.tmsystem.dto.TaskToCreateDto;
import com.example.tmsystem.model.Task;
import com.example.tmsystem.repository.TaskRepository;
import com.example.tmsystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.tmsystem.mapper.Mapper.toDomain;
import static com.example.tmsystem.mapper.Mapper.toDto;

@Service
@ApplicationScope
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskDto createTask(TaskToCreateDto taskToCreateDto) {
        var task = toDomain(taskToCreateDto);
        var user = userRepository.findById(taskToCreateDto.createdBy())
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id"));
        task.setCreatedBy(user);
        task.setCreatedAt(LocalDateTime.now());
        return toDto(taskRepository.save(task));
    }

    public TaskDto updateTask(TaskDto taskDto) {
        Task task = toDomain(taskDto);
        var assUser = taskDto.assignedTo() != null ? userRepository.findById(taskDto.assignedTo())
                .orElseThrow(() -> new EntityNotFoundException("not found")) : null;
        var createdByUser = userRepository.findById(taskDto.createdBy())
                .orElseThrow(() -> new EntityNotFoundException("one more huinya"));
        task.setAssignedTo(assUser);
        task.setCreatedBy(createdByUser);
        return toDto(taskRepository.save(task));
    }

    public TaskDto getTaskById(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("huy"));
        return toDto(task);
    }

    public List<TaskDto> getAllTasks() {
        List<TaskDto> taskDtoList = taskRepository.findAll()
                .stream()
                .map(i -> toDto(i))
                .toList();
        return taskDtoList;
    }

    public List<TaskDto> findAllTasksByAssignedToId(Integer id) {
        List<Task> taskList = taskRepository.findAllTasksByAssignedToId(id);
        List<TaskDto> taskDtoList = taskList
                .stream()
                .map(i -> toDto(i))
                .toList();
        return taskDtoList;
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

}
