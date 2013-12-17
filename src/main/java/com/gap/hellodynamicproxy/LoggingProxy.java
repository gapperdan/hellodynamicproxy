package com.gap.hellodynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * LoggingProxy - Since logging is not a business concern of the calculator, this proxy will be used to do
 * the logging and is isolated from the business code (calculating the numbers). This is AOP (aspect-oriented
 * programming).
 * @author da55296
 *
 */
public class LoggingProxy implements InvocationHandler {
	
	private Object object;  

	public LoggingProxy(Object object) {  
         this.object = object;  
    }  
	
	public static Object newInstance(Object object) {  
        return Proxy.newProxyInstance(object.getClass()  
                  .getClassLoader(), object.getClass()  
                  .getInterfaces(), new LoggingProxy(object));  
	} 
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
        Object result;  
        if (method.getName().contains("add")) {
			System.out.println("message from proxy: you called method="
					+ method.getName() + " with parameters="
					+ Arrays.toString(args));  
        }
        
        result = method.invoke(object, args);  
        return result;  
	} 

}
