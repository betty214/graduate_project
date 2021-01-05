package hello.hellospring.repository;

import hello.hellospring.domain.TimeTable;
import java.util.*;

public class MemoryTimetableRepository implements TimetableRepository{
    private static Map<Long, TimeTable> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public TimeTable save(TimeTable timetable) {
        timetable.setId(++sequence);
        store.put(timetable.getId(), timetable);
        return timetable;
    }

    @Override
    public Optional<TimeTable> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<TimeTable> findByName(String course_name) {
        return store.values().stream()
                .filter(timetable -> timetable.getCourse_name().equals(course_name))
                .findAny();
    }
    public void clearStore() {
        store.clear();
    }
}
