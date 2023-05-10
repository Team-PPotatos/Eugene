package org.example;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        Bank bank = new Bank();

        do {
            System.out.println("----- 💰은행 업무 처리 프로그램💰 -----");
            System.out.println("1. 계좌 생성하기");
            System.out.println("2. 입금하기");
            System.out.println("3. 출금하기");
            System.out.println("4. 비밀번호 변경하기");
            System.out.println("5. 프로그램 종료");
            System.out.print("원하는 업무 메뉴 입력 : ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.moneyIn();
                    break;
                case 3:
                    bank.moneyOut();
                    break;
                case 4:
                    bank.changePassword();
                    break;
                case 5:
                    System.out.print("정말로 종료하시겠습니까? (예:y / 아니오:n) : ");
                    String yesOrNo = sc.next();
                    if (yesOrNo.equals("y") || yesOrNo.equals("Y")) {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    break;
                default:
                    System.out.println("존재하지 않는 업무 서비스입니다. 다시 입력해주세요.");
                    break;
            }
        } while (true);
    }
}

