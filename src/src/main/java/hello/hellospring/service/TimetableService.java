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
    public Long join(TimeTable timeTable) {
        validateDuplicateTimetable(timeTable); //중복 회원 검증
        timetableRepository.save(timeTable);
        return timeTable.getId();
    }
    private void validateDuplicateTimetable(TimeTable timeTable) {
        timetableRepository.findByCName(timeTable.getCourse_name())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<TimeTable> findMembers() {
        return timetableRepository.findAll();
    }
    public Optional<TimeTable> findOne(Long timetableId) {
        return timetableRepository.findById(timetableId);
    }
}
