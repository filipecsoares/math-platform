package com.mathplatform.solutionevaluationservice.infra.repository;

import com.mathplatform.solutionevaluationservice.infra.model.SolutionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionJPARepository extends JpaRepository<SolutionModel, String> {

}
