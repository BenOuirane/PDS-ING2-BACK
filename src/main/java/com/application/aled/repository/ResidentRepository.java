/**
 * 
 */
package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Resident;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Repository
public interface ResidentRepository extends CrudRepository<Resident, String> {

}
