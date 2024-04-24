package com.TechM_VSM.VehicleServiceManagement.repository;

import com.TechM_VSM.VehicleServiceManagement.dto.VehicleDto;
import com.TechM_VSM.VehicleServiceManagement.model.ServiceStatus;
import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    Vehicle findByid(int id);

    List<Vehicle> findByServiceStatus(ServiceStatus serviceStatus);

    @Query("SELECT v FROM Vehicle v WHERE v.saEmail = ?1 AND v.serviceStatus = ?2")
    List<Vehicle> getVehicleListFromAdvisorAndServiceStatus(String sa_email, String service_status);

    List<Vehicle> findBySaEmail(String saEmail);
}
