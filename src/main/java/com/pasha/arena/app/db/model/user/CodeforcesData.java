package com.pasha.arena.app.db.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeforcesData {

    private String username;
    private String rank;
    private String maxRank;
    private Integer rating;
    private Integer maxRating;
    private LocalDateTime lastOnlineAt;
    private LocalDateTime registeredAt;
    private Integer submissionsCount;
    List<CodeforcesSubmission> submissions;
}