package app.service.time_sevice;

import app.entity.Time;
import org.springframework.stereotype.Service;

@Service
public interface TimeService {
    Time findTime(String time);
}
