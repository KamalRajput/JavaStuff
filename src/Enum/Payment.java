package Enum;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

public enum Payment {
    DEBITCARD(5),CREDITCARD(0),CASH(10);

    /*as all these enums defined are nothing but java classes , we can define main method here , constructors here also. but we rarely do it.
    Suppose in an application , u want your users to make use of credit card more . You can define some fees on payment types.
     */

    int fee;
    Payment( int fee){
        this.fee = fee;
    }
    public int getFee(){
        return this.fee;
    }

}
