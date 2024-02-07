package com.example.exbeginner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exbeginner.model.Member;
import com.example.exbeginner.repository.MemberRepository;


@Service
public class MemberService {
    @Autowired
    private MemberRepository repository;
    
    public List<Member> searchMember(String name) {
        return repository.searchMember(name);
    }
}
