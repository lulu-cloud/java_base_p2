package com.lili.p2.ui;

import com.lili.p2.bean.Customer;
import com.lili.p2.service.CustomerList;
import com.lili.p2.util.CMUtility;

import java.util.Scanner;

public class CustomerView {
    private CustomerList customerList=new CustomerList(10);

    //显示系统界面的方法
    public void enterMainMenu(){
        boolean Flag=true;
        while(Flag) {
            System.out.println("\n------------------客户管理软件----------------");
            System.out.println("                    1、添加用户                 ");
            System.out.println("                    2、修改用户                 ");
            System.out.println("                    3、删除用户                 ");
            System.out.println("                    4、客户列表                 ");
            System.out.println("                    5、退   出                 ");
            System.out.print("                    请选择(1-5):");

            //读入数字1-5
            char key= CMUtility.readMenuSelection();
            System.out.println();
            switch (key){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("退出");
                    System.out.print("确认是否退出(Y/N)?");
//                    Scanner scanner=new Scanner(System.in);
//                    String c=scanner.next();
                    char isExit=CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        Flag=false;
                        break;
                    }
//                    else if(isExit=='N'){
//
//                    }
            }
        }

    }

    private void addNewCustomer(){
        System.out.println("----------添加客户---------");
        Customer customer=new Customer();
        customer.setId(customerList.getTotal()+1);
        System.out.print("\n请输入客户姓名:");
        String name=CMUtility.readString(10);
        customer.setName(name);
        System.out.print("\n请输入客户性别:");
        String sex=CMUtility.readString(2,"男");
        customer.setSex(sex);
        System.out.print("\n请输入客户年龄:");
        int age=CMUtility.readInt("30");
        customer.setAge(age);
        System.out.print("\n请输入客户电话:");
        String phone=CMUtility.readString(20);
        customer.setPhone(phone);
        System.out.print("\n请输入客户邮箱:");
        String email=CMUtility.readString(30);
        customer.setEmail(email);
        customerList.addCustomer(customer);
        System.out.println("添加成功！");
    }

    private void modifyCustomer(){
        System.out.println("----------修改客户---------");
        System.out.print("请输入想要修改的客户编号(-1退出)");
        int id=CMUtility.readInt();
        if(id==-1) {
            System.out.println("修改失败！");
            return;
        }
        while (id<=0||id>customerList.getTotal()) {
            System.out.println("无法找到指定客户！请重新输入编号。");
            id=CMUtility.readInt();
        }
        Customer customer = customerList.getCustomer(id - 1);
        System.out.println("请输入更改后的个人信息(无需更改的直接回车)");
        customer.setId(id);
        System.out.print("\n请输入客户姓名:");
        String name=CMUtility.readString(20,customer.getName());
        customer.setName(name);
        System.out.print("\n请输入客户性别:");
        String sex=CMUtility.readString(2,customer.getSex());
        customer.setSex(sex);
        System.out.print("\n请输入客户年龄:");
        int age=CMUtility.readInt(String.valueOf(customer.getAge()));
        customer.setAge(age);
        System.out.print("\n请输入客户电话:");
        String phone=CMUtility.readString(20,customer.getPhone());
        customer.setPhone(phone);
        System.out.print("\n请输入客户邮箱:");
        String email=CMUtility.readString(30,customer.getEmail());
        customer.setEmail(email);

        customerList.replaceCustomer(id - 1, customer);
        System.out.println("修改成功！");
    }

    private void deleteCustomer(){
        System.out.println("----------删除客户---------");
        System.out.print("请输入想删除客户的编号(-1退出):");
        int id=CMUtility.readInt();
        if (id==-1){
            System.out.println("删除失败！");
            return;
        }
        while (id<=0||id>customerList.getTotal()){
            System.out.println("无法找到指定客户！请重新输入编号。");
            id=CMUtility.readInt();
        }
        customerList.deleteCustomer(id-1);
        System.out.println("删除成功！");
    }

    private void listAllCustomer(){
//        System.out.println("列表客户");
        System.out.println("--------------客户列表-------------");
        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱");
        for(Customer customer: customerList.getAllCustomers()){
            System.out.println(customer.getId()+"\t\t"+customer.getName()+"\t\t"+customer.getSex()+"\t\t"
                    +customer.getAge()+"\t\t"+customer.getPhone()+"\t\t"+customer.getEmail());
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        CustomerView view=new CustomerView();
        view.enterMainMenu();
    }

}
