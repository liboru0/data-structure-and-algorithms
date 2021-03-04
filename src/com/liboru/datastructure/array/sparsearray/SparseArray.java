package com.liboru.datastructure.array.sparsearray;

import java.io.*;

/**
 * 普通二维数组与稀疏数组的互相转换
 * @author lbr
 */
public class SparseArray {

    /**
     * @apiNote 将普通二维数组转换为稀疏数组
     * @param arrayTwo 普通二维数组
     * @return 稀疏数组
     * @author lbr
     */
    public static int[][] arrayToSparse(int[][] arrayTwo){

        // 遍历原始的二维数组，得到有效数据的个数sum
        int num = 0;
        for (int[] array : arrayTwo) {
            for (int i : array) {
                if(i!=0){
                    num++;
                }
            }
        }

        // 创建稀疏数组，并写入第一行数据
        int[][] sparseArray = new int[num+1][3];
        sparseArray[0][0] = arrayTwo.length;
        sparseArray[0][1] = arrayTwo[1].length;
        sparseArray[0][2] = num;

        // 将二维数组的有效数据存入到稀疏数组中
        num = 0;
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[i].length; j++) {
                if(arrayTwo[i][j]!=0){
                    num ++;
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = arrayTwo[i][j];
                }
            }
        }

        return sparseArray;
    }

    public static int[][] sparseToArray(int[][] sparse){

        int[][] arrayTwo = new int[sparse[0][0]][sparse[0][1]];

        for (int i = 1; i < sparse.length; i++) {
            arrayTwo[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }

        return arrayTwo;
    }

    /**
     * @apiNote 将二维数组写到指定的磁盘目录下
     * @param array 二维数组
     * @param fileFullName 文件全路径名
     * @author lbr
     */
    public static void writeDisk(int[][] array,String fileFullName){
        File file = new File(fileFullName);

        ObjectOutput output = null;

        try {
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(array);
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * @apiNote 将磁盘文件还原为二维数组
     * @param fileFullName 文件全路径名
     * @author lbr
     */
    public static int[][] readDisk(String fileFullName){
        File file = new File(fileFullName);
        ObjectInput input = null;
        int[][] sparseArray = null;
        try{
            input = new ObjectInputStream(new FileInputStream(file));
            sparseArray = (int[][])input.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparseArray;
    }



    /**
     * @apiNote 打印二维数组到控制台
     * @param arrayTwo 二维数组
     * @author lbr
     */
    public static void print(int[][] arrayTwo){
        for (int[] array : arrayTwo) {
            for (int i : array) {
                System.out.printf("%d\t",i);
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {

        int[][] arrayTwo = new int[6][7];
        arrayTwo[0][3] = 22;
        arrayTwo[0][6] = 15;
        arrayTwo[1][1] = 11;
        arrayTwo[1][5] = 17;
        arrayTwo[2][3] = -6;
        arrayTwo[3][5] = 39;
        arrayTwo[4][0] = 91;
        arrayTwo[5][2] = 28;
        System.out.println("原始的二维数组:=====================================");
        SparseArray.print(arrayTwo);

        int[][] sparseArray = SparseArray.arrayToSparse(arrayTwo);
        System.out.println("稀疏数组:=====================================");
        SparseArray.print(sparseArray);

        String fileFullName = "C:\\sparseArray.data";

        SparseArray.writeDisk(sparseArray,fileFullName);

        System.out.println("原始的二维数组:=====================================");
        int[][] array2 = SparseArray.sparseToArray(SparseArray.readDisk(fileFullName));
        SparseArray.print(array2);

    }

}
