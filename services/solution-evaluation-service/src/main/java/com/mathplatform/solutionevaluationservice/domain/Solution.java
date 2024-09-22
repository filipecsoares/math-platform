package com.mathplatform.solutionevaluationservice.domain;

import java.util.Objects;
import java.util.UUID;

public class Solution {

    private UUID id;
    private String answer;
    private String problemId;
    private String userId;

    public Solution(UUID id, String answer, String problemId, String userId) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("id is required");
        }
        this.id = id;
        this.answer = answer;
        this.problemId = problemId;
        this.userId = userId;
    }

    public static Solution create(String answer, String problemId, String userId) {
        return new Solution(UUID.randomUUID(), answer, problemId, userId);
    }

    public String getId() {
        return id.toString();
    }

    public String getAnswer() {
        return answer;
    }
    public String getProblemId() {
        return problemId;
    }

    public String getUserId() {
        return userId;
    }
}
