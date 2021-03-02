package fanshe;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * 利用反射读取字段值
 * getFields()：获得本类及其父类所有以public修饰的字段
 * getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
 */
public class CheckField {

	public static void main(String[] args) throws Exception{
        
		Employee e = new Employee("lujieni", 9000);
		testGetFieldValueByReflect(e);
		
	}

	public static void testGetFieldValueByReflect(Object model) throws Exception {
		//System.out.println(model.getClass().getName());fanshe.Employee
		for (Field field : model.getClass().getFields()) {
			boolean flag = field.isAccessible();
			field.set(model,"av");
			System.out.println(field.getName() + ":" + field.get(model));
			field.setAccessible(flag);
		}
	}

}

@Data
class Person{
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
}

class Employee extends Person{
	
	private double salary;
	
	public Employee(String name,double salary) {
		super(name);
		this.salary=salary;
	}
}




