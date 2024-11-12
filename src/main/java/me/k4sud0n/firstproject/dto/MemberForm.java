package me.k4sud0n.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import me.k4sud0n.firstproject.entity.Member;

@AllArgsConstructor
@ToString
public class MemberForm {
    private String email;
    private String password;

    public Member toEntity() {
        return new Member(null, email, password);
    }
}
