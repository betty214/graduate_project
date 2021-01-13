package hello.hellospring.repository;

import hello.hellospring.domain.TimeTable;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaTimetableRepository implements TimetableRepository{
    private final EntityManager em;

    public JpaTimetableRepository(EntityManager em) {
        this.em = em;
    }
    public TimeTable save(TimeTable timetable) {
        em.persist(timetable);
        return timetable;
    }

    @Override
    public List<TimeTable> findAll() {
        return null;
    }

}
