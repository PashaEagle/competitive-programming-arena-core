package com.pasha.arena.app.integration.codeforces.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoResponse {

    private String lastName;
    private String country;
    private Long lastOnlineTimeSeconds;
    private String city;
    private Integer rating;
    private Integer friendOfCount;
    private String titlePhoto;
    private String handle;
    private String avatar;
    private String firstName;
    private Integer contribution;
    private String organization;
    private String rank;
    private Integer maxRating;
    private Long registrationTimeSeconds;
    private String maxRank;
}
