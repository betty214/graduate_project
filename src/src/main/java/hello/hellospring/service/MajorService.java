package hello.hellospring.service;

import hello.hellospring.domain.Majors;
import hello.hellospring.domain.TimeTable;
import hello.hellospring.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;

public class MajorService {
    private final MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository){
        this.majorRepository=majorRepository;
    }

    public List<Majors> findMajor() {
        return majorRepository.findAll();
    }
}
