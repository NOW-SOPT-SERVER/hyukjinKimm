package org.sopt.practice.bank;

import java.awt.image.PackedColorModel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplicationMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Member> members = new ArrayList<>();


        while(true){
            showMenu();

            switch (sc.next()){
                case "1": // 회원가입
                    signUp(members);
                    break;
                case "2": // 입금
                    deposit(members);
                    break;
                case "3": // 출금
                    withDraw(members);
                    break;

                case "4": // 잔금 확인
                    showMoney(members);
                    break;
                case "5": // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("명령어를 다시 입력해 주세요");
                    break;


            }

        }




    }
    public static Member findMember(ArrayList<Member> members){

        Scanner sc = new Scanner(System.in);
        System.out.println("계좌번호를 입력해 주세요");
        if (sc.hasNextInt()){
            int account = sc.nextInt();
            if (account >= members.size() || account < 0){
                System.out.println("존재하지 않는 계좌번호 입니다.");
                System.out.println();
                return null;
            }
            return members.get(account);


        }
        else{
            System.out.println("유효한 값을 입력해 주세요. (숫자로)");
            System.out.println();
            return null;
        }


    }
    private static void showMenu(){
        System.out.println("다음중 메뉴를 선택해 주세요");
        System.out.println("1: 계좌생성");
        System.out.println("2: 입금");
        System.out.println("3: 출금");
        System.out.println("4: 잔금확인");
        System.out.println("5: 프로그램 종료");;

    }
    private static void signUp( ArrayList<Member> members){
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요");
        String name = sc.next();
        int MemberNumbers = Member.numbers;
        Member member =
                new MemberBuilder()
                        .account(MemberNumbers)
                        .money(0)
                        .name(name)
                        .build();

        members.add(member);
        System.out.println("계좌 생성 완료/ 당신의 계좌 번호: " + MemberNumbers);
        Member.addMember();
        System.out.println();

    }
    private static void deposit(ArrayList<Member> members){
        Scanner sc = new Scanner(System.in);
        Member member = findMember(members);
        if(member != null){
            System.out.println("입금할 금액을 입력해 주세요. (0원 보다 많이)");
            int money = sc.nextInt();
            member.deposit(money);
        }


    }
    private static void withDraw(ArrayList<Member> members){
        Member member = findMember(members);
        Scanner sc = new Scanner(System.in);
        if(member != null){
            System.out.println("출금할 금액을 입력해 주세요. (0원보다 많이)");
            int money = sc.nextInt();
            member.withdraw(money);
        }
    }
    private static void showMoney(ArrayList<Member> members){
        Member member = findMember(members);
        if (member != null) {
            Member.showMoney(member);
        }

    }
}
