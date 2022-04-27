package app.service.time_sevice;

import app.entity.Time;
import app.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public Time findTime(String time) {
        return timeRepository.findByTime(time);
    }
}
