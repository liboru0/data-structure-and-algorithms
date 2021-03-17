package com.liboru.algorithm.recursion;

public class SimpleRecursion {

    /**
     * @apiNote 台阶走法
     * @param stepNum 台阶数量
     * @author lbr
     */
    public int getStepThreads(int stepNum) {
        if (stepNum == 1) {
            return 1;
        }
        if (stepNum == 2) {
            return 2;
        }
        return getStepThreads(stepNum - 1) + getStepThreads(stepNum - 2);
    }

    public static void main(String[] args) {

    }

}
