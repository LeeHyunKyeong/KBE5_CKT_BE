package kernel360.ckt.collector.application.repository;

import java.util.Optional;
import kernel360.ckt.core.domain.entity.VehicleEntity;
import kernel360.ckt.core.domain.enums.VehicleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleRepository {
    VehicleEntity save(VehicleEntity vehicleEntity);
    void deleteById(Long vehicleId);
    Page<VehicleEntity> findAll(Pageable pageable);
    Page<VehicleEntity> search(VehicleStatus status, String keyword, Pageable pageable);
    Optional<VehicleEntity> findById(Long vehicleId);
}
