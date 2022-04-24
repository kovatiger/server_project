package app.service.status_service;

import app.entity.Status;
import org.springframework.stereotype.Service;

@Service
public interface StatusService {
    Status findStatusByStatusNameAndSaveIfDoesntExists(String statusName);
}
