package Reflection;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

@myAnnotation(value1="123",value2="456")
public class Calculator {

    private int num1;
    private int num2;

   public Calculator(){
        System.out.println("blank constructor");
    }
    public Calculator(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
