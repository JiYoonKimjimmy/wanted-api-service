package me.jimmyberg.wanted.api.v0.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public Hello save(Hello hello) {
        return helloRepository.save(hello);
    }

    public Hello findOneById(long id) {
        return helloRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Hello> findAll() {
        return helloRepository.findAll();
    }

    public List<Hello> findAllByText(String text) {
        return helloRepository.findAllByText(text);
    }

}
