package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
«JavaRush — лучший сервис обучения Java.»

Результат:
«— лучший сервис обучения»

На некорректные данные бросить исключение TooShortStringException (сделать исключением).
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string==null){
            throw new TooShortStringException();
        }
        int tmpSpace=0;
        for(int j = 0;j<string.length();j++){
            char[] chars = string.toCharArray();
            String charsString = String.valueOf(chars[j]);
            if(charsString.contains(" ")) tmpSpace++;
        }
        if(tmpSpace<4) throw new TooShortStringException();


        int tmpSecondIndex=0;
        char[] tmp = string.toCharArray();
        for(int i = 0,stop = 0;stop<4;i++){
            String tmpString = String.valueOf(tmp[i]);
            if(tmpString.equals(" ")){
                stop++;
                if(stop == 4)tmpSecondIndex = 1+i;
            }
        }
        int firstIndex = string.indexOf(" ")+1;
        int secondIndex = string.indexOf(" ",tmpSecondIndex);
        String finishString = "";
        if(secondIndex==-1){
            finishString = string.substring(firstIndex);
        }else{
            finishString = string.substring(firstIndex,secondIndex);
        }

        return finishString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
