package com.pasha.arena.app.db.model.user;

import com.pasha.arena.app.constant.Role;
import com.pasha.arena.app.db.model.user.data.GlobalData;
import com.pasha.arena.app.db.model.user.data.codeforces.CodeForcesData;
import com.pasha.arena.app.db.model.user.data.codewars.CodeWarsData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("user")
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

    private Long lastActiveAt;

    private GlobalData globalData;

    private String codeForcesUsername;
    private CodeForcesData codeForcesData;

    private String codeWarsUsername;
    private CodeWarsData codeWarsData;
}
