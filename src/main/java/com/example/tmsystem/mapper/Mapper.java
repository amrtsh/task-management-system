package com.example.tmsystem.mapper;

import com.example.tmsystem.dto.*;
import com.example.tmsystem.model.Task;
import com.example.tmsystem.model.User;

public class Mapper {

    public static RoleDto toDtoRole(User.Role role) {
        return switch (role) {
            case QA -> RoleDto.QA;
            case DEVELOPER -> RoleDto.DEVELOPER;
        };
    }

    public static StatusDto toDtoStatus(Task.Status status) {
        return switch (status) {
            case OPEN -> StatusDto.OPEN;
            case IN_PROCESS -> StatusDto.IN_PROCESS;
            case IN_QA_REVIEW -> StatusDto.IN_QA_REVIEW;
            case DONE -> StatusDto.DONE;
        };
    }

    public static PriorityDto toDtoPriority(Task.Priority priority) {
        return switch (priority) {
            case LOW -> PriorityDto.LOW;
            case MEDIUM -> PriorityDto.MEDIUM;
            case HIGH -> PriorityDto.HIGH;

        };
    }

    public static User.Role toDomainRole(RoleDto role) {
        return switch (role) {
            case QA -> User.Role.QA;
            case DEVELOPER -> User.Role.DEVELOPER;
        };
    }

    public static Task.Status toDomainStatus(StatusDto status) {
        return switch (status) {
            case OPEN -> Task.Status.OPEN;
            case IN_PROCESS -> Task.Status.IN_PROCESS;
            case IN_QA_REVIEW -> Task.Status.IN_QA_REVIEW;
            case DONE -> Task.Status.DONE;
        };
    }

    public static StatusDto toDtoStatus(StatusDto status) {
        return switch (status) {
            case OPEN -> StatusDto.OPEN;
            case IN_PROCESS -> StatusDto.IN_PROCESS;
            case IN_QA_REVIEW -> StatusDto.IN_QA_REVIEW;
            case DONE -> StatusDto.DONE;
        };
    }

    public static Task.Priority toDomainPriority(PriorityDto priority) {
        return switch (priority) {
            case LOW -> Task.Priority.LOW;
            case MEDIUM -> Task.Priority.MEDIUM;
            case HIGH -> Task.Priority.HIGH;
        };
    }


    public static UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                toDtoRole(user.getRole())
        );
    }

    public static User toDomain(UserAuthDto userAuthDto) {
        return User.builder()
                .name(userAuthDto.name())
                .surname(userAuthDto.surname())
                .email(userAuthDto.email())
                .password(userAuthDto.password())
                .role(toDomainRole(userAuthDto.role()))
                .build();
    }

    public static User toDomain(UserDto userDto) {
        return User.builder()
                .name(userDto.name())
                .surname(userDto.surname())
                .email(userDto.email())
                .role(toDomainRole(userDto.role()))
                .build();
    }

    public static TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                toDtoStatus(task.getStatus()),
                toDtoPriority(task.getPriority()),
                task.getCreatedAt(),
                task.getAssignedTo() != null ? task.getAssignedTo().getId() : null,
                task.getCreatedBy().getId()
        );
    }

    public static Task toDomain(TaskToCreateDto taskToCreateDto) {
        return Task.builder()
                .title(taskToCreateDto.title())
                .description(taskToCreateDto.description())
                .status(toDomainStatus(taskToCreateDto.status()))
                .priority(toDomainPriority(taskToCreateDto.priority()))
                .build();

    }

    // new
    public static Task toDomain(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.id())
                .title(taskDto.title())
                .description(taskDto.description())
                .status(toDomainStatus(taskDto.status()))
                .priority(toDomainPriority(taskDto.priority()))
                .createdAt(taskDto.createdAt())
                .build();
    }

}
