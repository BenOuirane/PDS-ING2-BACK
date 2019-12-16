/**
 * Class: CandidateRepository
 * @author: BEN OUIRANE Hajer
 * @version: 1.0
 */

package com.application.aled.repository;
import com.application.aled.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Since we'll need basic CRUD functionality on the Candidates entities,
 * we must also define a CandidateRepository interface
 */
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {
    Candidate findBymail( String  mail);

        }
