package org.sopt.practice;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;
import org.sopt.practice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MemberRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Member member = Member.builder().name("혁진").part(Part.SERVER).age(20).build();
        repository.save(member);


    }
}
