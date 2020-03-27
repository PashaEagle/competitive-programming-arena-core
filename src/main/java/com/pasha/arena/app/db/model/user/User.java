package com.pasha.arena.app.db.model.user;

import com.pasha.arena.app.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Document("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private Integer age;
    @NotNull
    private String group;
    @NotNull
    private Role role;
    @NotNull
    private Long lastActiveAt;

    private String codeForcesUsername;

    private String codeWarsUsername;
}
