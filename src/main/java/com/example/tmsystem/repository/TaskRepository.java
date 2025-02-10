package com.example.tmsystem.repository;

import com.example.tmsystem.dto.TaskDto;
import com.example.tmsystem.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllTasksByAssignedToId(Integer id);
}
