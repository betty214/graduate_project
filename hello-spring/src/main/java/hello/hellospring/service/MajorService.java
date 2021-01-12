package hello.hellospring.service;

import hello.hellospring.domain.Majors;
import hello.hellospring.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MajorService {
    private final MajorRepository majorRepository;
    public MajorService(MajorRepository majorRepository){
        this.majorRepository=majorRepository;
    }
    public void makeTimetable() {

    }
    public List<Majors> findMajor() {
        for(Majors value : majorRepository.findByRT(32)) {
            System.out.println(value.getMajor_name());
        }
        return majorRepository.findByRT(32);
    }
}
