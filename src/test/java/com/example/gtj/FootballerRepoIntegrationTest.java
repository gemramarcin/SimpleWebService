package com.example.gtj;

import com.example.gtj.footballers.Footballer;
import com.example.gtj.footballers.FootballerRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FootballerRepoIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FootballerRepo footballerRepo;

    @Test
    public void whenFindByName_thenReturnFootballer() {
        // given
        Footballer cr7 = new Footballer();
        entityManager.persist(cr7);
        entityManager.flush();

        // when
        Optional<Footballer> found = footballerRepo.findById(cr7.getId());


        // then
        assertThat(found.get())
                .isEqualTo(cr7);
    }

}
