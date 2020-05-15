/**
 * Class: CandidateRepository
 * @author: BEN OUIRANE Hajer
 * @version: 1.0
 */

package com.application.aled.repository;
import com.application.aled.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {


    Candidate findBymail( String  mail);
    List<Candidate> findAll();



}
