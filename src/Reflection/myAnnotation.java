package Reflection;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface myAnnotation {

    public String value1();
    public String value2();
}
