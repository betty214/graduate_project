package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.TimeTable;

import java.util.List;
import java.util.Optional;

public interface TimetableRepository {
    TimeTable save(TimeTable timetable);
    Optional<TimeTable> findById(Long id);
    Optional<TimeTable> findByName(String course_name);
}
