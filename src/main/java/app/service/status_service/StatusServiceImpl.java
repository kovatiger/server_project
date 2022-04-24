package app.service.status_service;

import app.entity.Status;
import app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status findStatusByStatusNameAndSaveIfDoesntExists(String statusName) {
        Status status = statusRepository.findStatusByStatusName(statusName);
        if (status == null) {
            Status userStatus = new Status();
            userStatus.setStatusName(statusName);
            statusRepository.save(userStatus);
            return userStatus;
        } else return status;
    }
}

