package org.example;

import java.util.Scanner;

public class Bank {
    private int index = 0;
    private String accountNumber;
    private Service[] accounts = new Service[100];
    public int checkAccountnumber(String accountNumber) {
        for (int i = 0; i < index; i++) {
            if (accounts[i].getAccountNumber().contentEquals(accountNumber)) {
                return i;
            }
        } return -1;
    }
    // (check머시기로 부터 받은 인덱스가 -1인지 아닌지를 확인 후 계좌가 존재하는지 아닌지 리턴),
    //public void findAccount() {}
    public void changePassword() {
        Scanner scan = new Scanner(System.in);

        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = scan.next();
        System.out.print("현재 비밀번호를 입력해주세요: ");
        String pwd = scan.next();
        System.out.print("새로운 비밀번호를 입력해주세요: ");
        String newPwd = scan.next();

        index = checkAccountnumber(accountNumber);
        if (index != -1) {
            accounts[index].setPassword(newPwd);
            System.out.println("비밀번호가 " + newPwd + "로 변경되었습니다.");
        } else {
            System.out.println("존재하지 않는 계좌번호 입니다.");
        }
    }
    public void createAccount() {
        Scanner scan = new Scanner(System.in);

        System.out.print("계좌번호 : ");
        String accountNumber = scan.next();
        System.out.print("이름 : ");
        String name = scan.next();
        System.out.print("비밀번호 : ");
        String password = scan.next();
        System.out.print("잔액 : ");
        int budget = scan.nextInt();

        accounts[index] = new Service(accountNumber, name, password, budget);
        index++;

        System.out.println("계좌가 개설되었습니다.");

    }
    public void moneyOut() {
        Scanner scan = new Scanner(System.in);

        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = scan.next();
        System.out.print("비밀번호를 입력해주세요: ");
        String pwd = scan.next();
        System.out.print("출금하실 금액을 입력해주세요: ");
        int amount = scan.nextInt();

        index = checkAccountnumber(accountNumber);
        if (index != -1) {
            if (!accounts[index].getPassword().equals(pwd)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                return;
            }
            accounts[index].withdraw(amount);
            System.out.println(amount + "원이 출금되었습니다. 잔액은 " + accounts[index].getBudget() + "원 입니다.");
        } else {
            System.out.println("존재하지 않는 계좌번호 입니다.");
        }
    }
    public void moneyIn() {
        Scanner scan = new Scanner(System.in);

        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = scan.next();
        System.out.print("입금하실 금액을 입력해주세요: ");
        int amount = scan.nextInt();

        index = checkAccountnumber(accountNumber);
        if (index != -1) {
            accounts[index].deposit(amount);
            System.out.println(amount + "원이 입금되었습니다. 잔액은 " + accounts[index].getBudget() + "원 입니다.");
        } else {
            System.out.println("존재하지 않는 계좌번호 입니다.");
        }
    }

}
