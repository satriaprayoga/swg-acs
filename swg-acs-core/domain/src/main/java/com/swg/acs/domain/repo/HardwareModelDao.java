package com.swg.acs.domain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swg.acs.domain.HardwareModel;

/**
 * @author Puradidjaja
 *
 */
public interface HardwareModelDao extends JpaRepository<HardwareModel, Long>{

	public HardwareModel findByOui(String oui);
	public List<HardwareModel> findByManufacturer(String manufacturer);
}
