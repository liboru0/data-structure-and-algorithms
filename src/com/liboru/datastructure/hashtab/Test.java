package com.liboru.datastructure.hashtab;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);

        String key = "";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("请输入id:");
                    int id = scanner.nextInt();
                    System.out.println("请输入name:");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    hashTable.add(employee);
                    break;
                case "list":
                    System.out.println(hashTable);
                    break;
                case "find":
                    System.out.println("请输入要查找的id:");
                    int findId = scanner.nextInt();
                    Employee emp = hashTable.findEmpById(findId);
                    System.out.println(emp != null ? emp : "没找到!!!");
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("已推出");
                    return;
                default:
                    break;
            }
        }

    }

}
