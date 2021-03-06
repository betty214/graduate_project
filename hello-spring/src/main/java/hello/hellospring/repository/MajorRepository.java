package hello.hellospring.repository;

import hello.hellospring.domain.Majors;
import hello.hellospring.domain.User;
import hello.hellospring.domain.User1_dropmajor;

import java.util.List;
import java.util.Optional;

public interface MajorRepository {
    Optional<Majors> findMajor(String major_name, int major_number, int division_number);
    List<Majors> findByRT(int recommend_time);
    List<Majors> findAll();
    List<User> findNoTime();
    List<User1_dropmajor> findNoThing();
}
