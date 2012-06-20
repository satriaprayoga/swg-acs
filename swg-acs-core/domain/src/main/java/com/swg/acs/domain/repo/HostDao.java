package com.swg.acs.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swg.acs.domain.Host;

/**
 * @author Puradidjaja
 * 
 */
public interface HostDao extends JpaRepository<Host, Long> {

	Host findByUserName(String userName);

}
