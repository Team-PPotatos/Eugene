package org.example;

public class Service {
    private String accountNumber;
    private String password;
    private int budget;
    private String name;

    public Service(String accountNumber, String name, String password, int budget) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.budget = budget;
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPwd) {
        if (password == newPwd) {
            System.out.println("이전의 비밀번호와 같은 입력입니다. 다시 입력하세요.");
            return;
        }
        password = newPwd;
    }

    public void deposit(int deposit) {
        if (deposit <= 0) {
            System.out.println("잘못된 입력입니다. 금액을 다시 입력하세요.");
            return;
        }
        budget += deposit;
    }

    public void withdraw(int withdraw) {
        if (withdraw > budget) {
            System.out.println("잔액이 부족합니다. " + budget + "이하의 금액으로 다시 입력해주세요.");
            return;
        }
        budget -= withdraw;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
