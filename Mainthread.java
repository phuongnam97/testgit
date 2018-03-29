package view;

import controller.AccountController;
import entity.Account;
import model.AccountModel;

import java.util.Scanner;

public class Mainthread {
    public static void main(String[] args) {
        generateMenu();
    }
	//Comment
    public static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();
        AccountModel accountModel = new AccountModel();
        Account account = new Account();
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("3. Thoát");
            System.out.println("Vui lòng lựa chọn chức năng");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    account = accountController.signIn();
                    if(accountModel.checkExistAccount(account)){
                        System.out.println("Đăng nhập thành công!!!");
                        boolean a = true;
                        while(a) {
                            System.out.println("=======================");
                            System.out.println("1. Truy vấn số dư tài khoản");
                            System.out.println("2. Rút tiền");
                            System.out.println("3. Gửi tiền");
                            System.out.println("4. Thoát");
                            int choice1 = scanner.nextInt();
                            switch (choice1){
                                case 1:
                                    accountModel.checkBalance(account);
                                    break;
                                case 2:
                                    accountModel.getMoney(account);
                                    break;
                                case 3:
                                    accountModel.pushMoney(account);
                                    break;
                                case 4:
                                    System.out.println("Bạn đã thoát");
                                    a= false;
                                default:
                                    System.out.println("Bạn đã chọn sai, vui lòng chọn từ 1>4");
                                    break;
                            }
                        }
                    }
                    else System.out.println("Đăng nhập không thành công");
                    break;
                case 2:
                    account = accountController.createAccount();
                    if (account.isValid() && !accountModel.checkExistUsername(account.getUsername())){
                        accountModel.insert(account);
                        System.out.println("Đăng kí thành công");
                    }
                    break;
                case 3:
                    System.out.println("Bạn đã chọn thoát");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
