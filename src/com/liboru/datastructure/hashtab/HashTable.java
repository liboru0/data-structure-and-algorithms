package com.liboru.datastructure.hashtab;

public class HashTable {

    private EmpLinkedList[] empLinkedListArr;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    public void add(Employee employee) {
        // 根据员工的id，得到员工应当添加到哪条链表
        int empLinkedListNo = hashFun(employee.getId());
        empLinkedListArr[empLinkedListNo].add(employee);
    }

    public Employee findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        if(empLinkedListNo>=size){
            return null;
        }
        return empLinkedListArr[empLinkedListNo].findEmployeeById(id);
    }



    // 散列函数，取模法
    public int hashFun(int id) {
        return id % size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("-------------------\r\n");
        for (int i = 0; i < size; i++) {
            str.append(i).append(empLinkedListArr[i].toString()).append("\r\n");
        }
        str.append("-------------------\r\n");
        return str.toString();
    }




}
