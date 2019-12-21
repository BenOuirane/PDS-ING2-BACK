/**
 * 
 */
package com.application.aled.repository;

import com.application.aled.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Resident;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Repository
public interface ResidentRepository extends CrudRepository<Resident, String> {

	Resident findByUser(User user);

}
