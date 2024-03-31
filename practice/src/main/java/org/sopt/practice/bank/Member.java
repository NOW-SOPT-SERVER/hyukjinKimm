package org.sopt.practice.bank;

import java.util.ArrayList;

public class Member {


    public static int numbers = 0;
    private final int account;
    private int money;
    private String name;

    public Member(int account, int money, String name) {
        this.account = account;
        this.money = money;
        this.name = name;
    }

    

    public int getAccount() {
        return account;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(int money){
        if (money <= 0) {
            System.out.println("0원 이하는 입금 불가");
            System.out.println();
        } else{
            this.money += money;

            System.out.println(this.name + " 에게 입금 완료");
            System.out.println(this.name + "님의 현재 잔액: " + this.money);
            System.out.println();
        }
    }
    public void withdraw(int money){
        if (money <= 0) {
            System.out.println("0원 이하는 출금할 수 없습니다.");
            return;
        }
        if (this.money < money) {
            System.out.println("출금 금액이 잔액보다 큽니다.");
            System.out.println();
        } else{
            this.money -= money;
            System.out.println(this.name + "님의 출금 완료");
            System.out.println(this.name + "님의 현재 잔액: " + this.money);
            System.out.println();
        }
    }
    public static void showMoney(Member member){
        System.out.println(member.getName() + "님의 남은 금액은 " + member.getMoney() + " 입니다.");
        System.out.println();
    }

    public static void addMember(){
        Member.numbers += 1;
    }

}
