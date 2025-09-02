package com.example.logmonitor.repository;

import com.example.logmonitor.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByService(String service);
    List<Alert> findByLevel(String level);
}
