package hello.hellospring.repository;

import hello.hellospring.domain.TimeTable;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaTimetableRepository implements MemberRepository{
    private final EntityManager em;

    public JpaTimetableRepository(EntityManager em) {
        this.em = em;
    }
    public TimeTable save(TimeTable timetable) {
        em.persist(timetable);
        return timetable;
    }
    public Optional<TimeTable> getId(Long id) {
        TimeTable timetable = em.find(TimeTable.class, id);
        return Optional.ofNullable(timetable);
    }
    public Optional<TimeTable> getCourse_name(String name) {
        List<Member> result = em.createQuery("select m from time_table m where m.course_name = :couse_ name", Member.class)
                .setParameter("course_name", course_name)
                .getResultList();
        return result.stream().findAny();
    }
}
