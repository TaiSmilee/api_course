package com.example.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "permission")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Permission {
    @Id
    @Column(name = "permission_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(name = "permission_name", columnDefinition = "VARCHAR(100)")
    private String permissionName;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "permission")
    private List<PermissionUser> users;

    @JsonIgnore
    @OneToMany(mappedBy = "permission")
    private List<RolePermission> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "permission")
    private List<BannedPermission> bannedUsers;
}
