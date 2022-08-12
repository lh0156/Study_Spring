package Pratice.AOP.service;

import Pratice.AOP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public void test() {
        System.out.println("MemberService.Test");
    }



}
