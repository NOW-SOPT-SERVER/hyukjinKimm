package clone.carrot.doamin.dto;

import clone.carrot.doamin.Member;

public record MemberFindDto(
        String name,
        int age

){
    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(member.getName(), member.getAge());
    }
}