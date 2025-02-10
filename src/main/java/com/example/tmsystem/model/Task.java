package com.example.tmsystem.model;

import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    public enum Status {
        OPEN,
        IN_PROCESS,
        IN_QA_REVIEW,
        DONE
    }

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    @NotNull
    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // date

    @ManyToOne
    @JoinColumn(name = "assigned_to_id", referencedColumnName = "id")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "created_by_id", referencedColumnName = "id", nullable = false)
    private User createdBy;
}
