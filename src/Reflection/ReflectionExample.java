package Reflection;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {

  public static void main(String args[])
  {
      try {
          //System.out.println(Class.forName(Calculator.class.getName()));
          Class<?> myClass = Class.forName(Calculator.class.getName());
          System.out.println(myClass.getName());
          Constructor<?>[] constructors = myClass.getConstructors();
          //so here , by default public fields will be accessed, thats why i have made the constructors as public. otherwise a  blank array will be returned.
          System.out.println(Arrays.toString(constructors));
          System.out.println(Arrays.toString(myClass.getMethods()));

          //Calling specific constructor by creating an instance.
          Constructor<?> constructor1 = myClass.getConstructor(null);
          System.out.println(constructor1.newInstance(null));

          Constructor<?> constructor2 = myClass.getConstructor(int.class,int.class);
         // System.out.println(constructor2.newInstance(5,6));
          Object myObj = constructor2.newInstance(5, 6);
          //invoking setters
          Method setNum1 = myClass.getMethod("setNum1", int.class);
          setNum1.invoke(myObj,10);

          Method setNum2 = myClass.getMethod("setNum2", int.class);
          setNum2.invoke(myObj,8);

          //Modifying private fields
          Field num1 = myClass.getDeclaredField("num1");
          num1.setAccessible(true);
          num1.set(myObj,80);
          //invoking getters
          Method method = myClass.getMethod("getNum1", null);
            System.out.println(method.invoke(myObj,null));

          Method method1 = myClass.getMethod("getNum2", null);
          System.out.println(method1.invoke(myObj,null));

            //Accessing Annotations
          Annotation[] annotations = myClass.getAnnotations();
            System.out.println(Arrays.toString(annotations));
            //Accessing fields on annotations
          myAnnotation annotation = (myAnnotation)annotations[0];
          System.out.println(annotation.value1());
          System.out.println(annotation.value2());

      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (NoSuchMethodException e) {
          e.printStackTrace();
      } catch (IllegalAccessException e) {
          e.printStackTrace();
      } catch (InstantiationException e) {
          e.printStackTrace();
      } catch (InvocationTargetException e) {
          e.printStackTrace();
      } catch (NoSuchFieldException e) {
          e.printStackTrace();
      }


  }
}
