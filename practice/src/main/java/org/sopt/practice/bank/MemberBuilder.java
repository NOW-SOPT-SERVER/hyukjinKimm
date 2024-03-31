package org.sopt.practice.bank;

public class MemberBuilder {

    private int account;
    private int money;
    private String name;

    public MemberBuilder account(int account) {
        this.account = account;
        return this;
    }

    public MemberBuilder money(int money) {
        this.money = money;
        return this;
    }

    public MemberBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Member build() {
        return new Member(account, money, name);
    }


}
