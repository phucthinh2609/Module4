package com.mvpt.repository;

import com.mvpt.model.LocationRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationRegion, Long> {
}
