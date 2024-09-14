package com.mathplatform.mathproblemservice.infra.repository;

import com.mathplatform.mathproblemservice.infra.model.ProblemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemJpaRepository extends JpaRepository<ProblemModel, String> {

}
