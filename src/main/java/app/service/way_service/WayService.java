package app.service.way_service;

import app.entity.Way;
import org.springframework.stereotype.Service;

@Service
public interface WayService {
    Way findWay(String way);
}
