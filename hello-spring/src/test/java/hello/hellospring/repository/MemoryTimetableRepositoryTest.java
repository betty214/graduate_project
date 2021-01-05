package hello.hellospring.repository;

import hello.hellospring.domain.TimeTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryTimetableRepositoryTest {

    MemoryTimetableRepository repository = new MemoryTimetableRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void findByName() {
        //given
        TimeTable tt1 = new TimeTable();
        tt1.setCourse_name("컴퓨터네트워크");
        //when
        TimeTable result = repository.findByName("컴퓨터네트워크").get();
        //then
        assertThat(result).isEqualTo(tt1);
    }
}