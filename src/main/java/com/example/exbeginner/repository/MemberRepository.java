package com.example.exbeginner.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.exbeginner.model.Member;

@Repository
public class MemberRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Member> searchMember(String name) {
        System.out.println("Repositoryが呼ばれた");
        System.out.println(name);
        return new ArrayList<Member>();
    }
    
}
