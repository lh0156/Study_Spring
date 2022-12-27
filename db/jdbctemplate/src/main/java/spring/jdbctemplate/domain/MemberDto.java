package spring.jdbctemplate.domain;

import lombok.Data;

@Data
public class MemberDto {

    private String memberName;
    private String memberAddress;
    private String memberGender;

    public MemberDto(String membername, String memberaddress, String membergender) {
        this.memberName = membername;
        this.memberAddress = memberaddress;
        this.memberGender = membergender;
    }
}
