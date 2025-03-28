package com.example.course.entity;

import com.example.course.entity.composite.PermissionUserId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banned_permission")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BannedPermission {
    @EmbeddedId
    private PermissionUserId id;
    // Relation "One"

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    private Permission permission;

    @JsonIgnore
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
