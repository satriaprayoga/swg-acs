package com.swg.acs.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swg.acs.domain.Software;

/**
 * @author Puradidjaja
 *
 */
public interface SoftwareDao extends JpaRepository<Software, Long> {

}
