/**
 * 
 */
package com.application.aled.repository;
import com.application.aled.entity.ReferentialLocation;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Repository
public interface LocationRepository extends CrudRepository<ReferentialLocation, Integer>{

}
