package org.example;

class FloatTest {
    public static void main(String []args){

        float total = 0;
        var correctTotal = 0;

        for (int i = 0; i < 23512318; i++) {

            correctTotal += 3;

            float a = 0.1f;
            float b = 0.2f;
            float c = a+b; // 0.3

            total += c;

        }

        System.out.println(correctTotal / 10);
        System.out.println(total);
    }
}

