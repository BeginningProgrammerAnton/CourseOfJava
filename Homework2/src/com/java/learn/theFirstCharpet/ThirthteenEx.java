package com.java.learn.theFirstCharpet;

import java.util.Arrays;
import java.util.Random;

public class ThirthteenEx {
// выводит новый массив без элемента по указанному индексу
    private int[] deleteElem(int[] ar, int index) {
        int[] arr = new int[ar.length - 1];
        for (int i = 0,j = 0; i < ar.length; i ++,j++) {
            if ( i != index) {
                arr[j] = ar[i];
                continue;
            }
            j--;
        }
        return arr;
    }
// получаем случайное число
    private int getElem (int [] arr) {
        Random rnd = new Random(System.currentTimeMillis());
        int number = rnd.nextInt(arr.length);
        return number;
    }
// показать итоговый массив
    private void ShowRes(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
// получить число из массива по индексу
    private int getNumber(int[] array,int x) {
        return array[x];
    }
// основная функция получаения массива
    public void getResult() {
        int[] arr = new int[49];
        int[] result = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int tmp = 0;
        while(tmp != 6) {
            int index = getElem(arr);
            result[tmp] = getNumber(arr,index);
            arr = deleteElem(arr,index);
            tmp++;
        }
        ShowRes(result);
    }
}
