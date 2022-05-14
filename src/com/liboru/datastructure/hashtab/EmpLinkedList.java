package com.liboru.datastructure.hashtab;

public class EmpLinkedList {

    private Employee first;

    public void add(Employee employee) {

        if (first == null) {
            first = employee;
            return;
        }

        Employee temp = first;
        while (first.next != null) {
            temp = temp.next;
        }

        temp.next = employee;

    }

    public Employee findEmployeeById(int id) {
        if (first == null) {
            return null;
        }
        Employee temp = first;
        while (temp != null) {
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        String str = "[";

        Employee temp = first;
        while (temp != null) {
            str += temp.toString() + "->";
            temp = temp.next;
        }

        str = str.substring(0, str.length() - 2) + "]";

        return str;
    }

}
