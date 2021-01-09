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
    public Optional<TimeTable> findById(Long id) {
        TimeTable timetable = em.find(TimeTable.class, id);
        return Optional.ofNullable(timetable);
    }

    @Override
    public Optional<TimeTable> findByCName(String course_name) {
        List<TimeTable> result = em.createQuery("select m from time_table m where m.course_name = :course_name", TimeTable.class)
                .setParameter("course_name", course_name)
                .getResultList();
        return result.stream().findAny();
    }


    @Override
    public List<TimeTable> findAll() {
        return null;
    }

}
