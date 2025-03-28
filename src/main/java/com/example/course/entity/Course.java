package com.example.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @Column(name = "course_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Lob
    @Nullable
    @Column(name = "thumbnail", columnDefinition = "LONGBLOB")
    private byte[] thumbnail;

    @Column(name = "price")
    private Long price;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Folder> folders;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<CourseSchedule> courseSchedules;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<CourseRoomMessage> courseRoomMessages;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<CourseLecturer> lecturers;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<CourseStudent> students;

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

}