package com.qunar.study.xiaosxian.base.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getAge() {
		return age;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person("mjw",28);
		Class clazz = person.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field :fields) {
			String key = field.getName();
			System.out.println(key);
			try {
				PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
				System.out.println(descriptor.toString());
				Method method = descriptor.getReadMethod();
				Object value = method.invoke(person);
				System.out.println(key + ":" + value);
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
