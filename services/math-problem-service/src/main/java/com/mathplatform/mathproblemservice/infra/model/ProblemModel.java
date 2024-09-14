package com.mathplatform.mathproblemservice.infra.model;

import com.mathplatform.mathproblemservice.domain.Problem;
import jakarta.persistence.*;

@Entity
public class ProblemModel {

    @Id
    private String id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String answer;
    @ManyToOne
    private MathCategoryModel category;
    private String difficulty;

    public ProblemModel() {
    }

    public ProblemModel(String id, String description, String answer, MathCategoryModel category, String difficulty) {
        this.id = id;
        this.description = description;
        this.answer = answer;
        this.category = category;
        this.difficulty = difficulty;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public MathCategoryModel getCategory() {
        return category;
    }
    public void setCategory(MathCategoryModel category) {
        this.category = category;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static ProblemModel fromDomain(Problem problem) {
        var category = problem.getCategoryId() != null ? new MathCategoryModel(problem.getCategoryId()) : null;
        return new ProblemModel(
                problem.getId(),
                problem.getDescription(),
                problem.getAnswer(),
                category,
                problem.getDifficult());
    }

    public Problem toDomain() {
        return new Problem(
                this.description,
                this.answer,
                this.category != null ? this.category.getId() : null,
                this.difficulty);
    }
}
