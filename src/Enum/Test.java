package Enum;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

public class Test {

    public static void main(String args[]) {
        Payment pt = Payment.CREDITCARD;
       //System.out.println(pt);

    //values - used to get all the values in Enum class, ordinal is used to refer to the position of the enum element.
        Payment[] values = Payment.values();
        for(Payment p:values){
            System.out.println(p);
            System.out.println(p.ordinal());
            System.out.println(p.getFee());
        }
    }

}
