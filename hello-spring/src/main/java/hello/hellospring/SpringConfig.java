package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MajorService;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
    @Bean
    public TimetableService timetableService(){
        return new TimetableService(timetableRepository());
    }
    @Bean
    public TimetableRepository timetableRepository() {
        return new JpaTimetableRepository(em);
    }
    @Bean
    public MajorService majorService(){
        return new MajorService(majorRepository());
    }
    @Bean
    public MajorRepository majorRepository() {
        return new JpaMajorRepository(em);
    }
}
