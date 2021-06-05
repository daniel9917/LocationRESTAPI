package com.bancob.location.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bancob.location.app.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
