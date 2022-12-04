

package com.example.calc;

public class Model {

    public long calculation(long a,long b,String operator){
        switch (operator){
            case"+":
            return a+b;
            case"-":
                return a-b;
            case"*":
                return a*b;
            case"^2":
                return a*a;

            case"/":
                if(b==0) return 0;
                return a/b;


        }
        System.out.println("Неизвестный оператор " + operator);
        return 0;
    }


}
