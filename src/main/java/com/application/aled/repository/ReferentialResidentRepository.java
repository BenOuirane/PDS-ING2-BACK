/**
 * 
 */
package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.ReferentialResident;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Repository
public interface ReferentialResidentRepository extends CrudRepository<ReferentialResident, Integer> {
	//ReferentialResident findByIdResident(int refResi);
	/*static ReferentialResident refResident(int refResi) {
		// TODO Auto-generated method stub
		return null;
	}// throws NullPointerException */

}
