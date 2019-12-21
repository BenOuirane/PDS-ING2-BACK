/**
 * 
 */
package com.application.aled.repository;

import com.application.aled.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Residents;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Repository
public interface ResidentRepository extends CrudRepository<Residents, String> {

	Residents findByUser(User user);

}
