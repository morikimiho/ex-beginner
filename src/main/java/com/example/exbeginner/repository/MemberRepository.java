package com.example.exbeginner.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exbeginner.model.Member;

@Repository
public class MemberRepository {
    private static final String SEARCH_MEMBER ="""
            SELECT
                name
            FROM
                members
            WHERE
                name LIKE :name;
            """;

    private static final RowMapper<Member> MEMBER_ROWMAPPER = (rs, rowNum) -> {
        Member member = new Member();
        member.setName(rs.getString("name"));
        return member;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Member> searchMember(String name) {
        SqlParameterSource params = new MapSqlParameterSource()
            .addValue("name", "%" + name + "%");
        List<Member> members = template.query(SEARCH_MEMBER, params, MEMBER_ROWMAPPER);

        return members;
    }
    
}
