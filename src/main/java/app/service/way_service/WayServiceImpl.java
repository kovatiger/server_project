package app.service.way_service;

import app.entity.Way;
import app.repository.WayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WayServiceImpl implements WayService{
    @Autowired
    private WayRepository wayRepository;
    @Override
    public Way findWay(String way) {
        return wayRepository.findByWay(way);
    }
}
