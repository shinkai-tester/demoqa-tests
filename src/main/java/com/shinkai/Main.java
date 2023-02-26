package com.shinkai;

public class Main {

    public static void main(String[] args) {
        // Арифметические операторы, логические операторы
        int a = 28;
        int b = 13;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("Остаток от деления a на b: " + (a % b));
        /*Рекомендуется писать в циклах ++i а не i++
        i++ возвращает i, потом увеличивает на 1. ++i увеличивает i на 1, потом возвращает.
         */

        System.out.println(a > 3 && a < 30); // true
        System.out.println(b > 15 && b < 30); // false
        System.out.println(b > 15 || b < 30); // true
        System.out.println(!(a >= 28)); // false
        int number = a;
        String greaterThan50 = number > 50 ? "The number is greater than 50" : "The number is NOT greater than 50";
        System.out.println(greaterThan50);

        System.out.println("a++   = " +  (a++));
        System.out.println("b--   = " +  (b--));
        System.out.println("++a   = " +  (++a));
        System.out.println("--a   = " +  (--b));

        // Переполнение
        int maxInt = 2147483647;
        System.out.println(maxInt + 1); // -2147483648
        double maxDouble = Double.MAX_VALUE;
        System.out.println(maxDouble); // 1.7976931348623157E308
        System.out.println(maxDouble + 1); // 1.7976931348623157E308

        // Вычисления комбинаций типов данных
        int c = 2;
        double d = 2.3;
        System.out.println(c + d); // double value
        System.out.println(c - d); // double value
    }
}