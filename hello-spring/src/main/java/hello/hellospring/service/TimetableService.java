package hello.hellospring.service;

import hello.hellospring.domain.TimeTable;
import hello.hellospring.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
public class TimetableService {
    private final TimetableRepository timetableRepository;
    @Autowired
    public TimetableService(TimetableRepository timetableRepository){
        this.timetableRepository=timetableRepository;
    }
    /**
     * 회원가입
     */

    public List<TimeTable> findMembers() {
        return timetableRepository.findAll();
    }
}
