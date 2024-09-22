package com.mathplatform.solutionevaluationservice.infra.model;

import com.mathplatform.solutionevaluationservice.domain.Solution;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "solution")
public class SolutionModel {

    @Id
    private String id;
    @Column(nullable = false)
    private String problemId;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String answer;

    public SolutionModel() {
    }

    public SolutionModel(String id, String problemId, String userId, String answer) {
        this.id = id;
        this.problemId = problemId;
        this.userId = userId;
        this.answer = answer;
    }

    public static SolutionModel fromDomain(final Solution solution) {
        return new SolutionModel(solution.getId(), solution.getProblemId(), solution.getUserId(), solution.getAnswer());
    }

    public Solution toDomain() {
        return new Solution(UUID.fromString(id), answer, problemId, userId);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProblemId() {
        return problemId;
    }
    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
