package fanshe;

import java.lang.reflect.Field;

public class CheckField {

	public static void main(String[] args) throws Exception{
        
		Employee e = new Employee("lujieni", 9000);
		testReflect(e);
		
	}

	public static void testReflect(Object model) throws Exception {
		//System.out.println(model.getClass().getName());fanshe.Employee
		for (Field field : model.getClass().getFields()) {
			field.setAccessible(true);
			System.out.println(field.getName() + ":" + field.get(model));
		}
	}

}

class Person{
	protected String name;
	
	public Person(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class Employee extends Person{
	
	private double salary;
	
	public Employee(String name,double salary) {
		super(name);
		this.salary=salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
	
}




