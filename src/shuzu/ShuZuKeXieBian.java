package shuzu;

/**
 * 数组是可协变的,所有数组都要牢记创建它们的元素类型,staff数组
 * 会时刻记得它存储的是mananger元素
 */
public class ShuZuKeXieBian {
 
	public static void main(String[] args) {
		/*
		 * 编译器竟然接纳了这个赋值操作。但在这里， stafflO] 与 manager[0] 引用的是同一个
		      对象， 似乎我们把一个普通雇员擅自归入经理行列中了。这是一种很忌伟发生的情形，
		      当调用 managers[0].setBonus(100) 的时候， 将会导致调用一个不存在的实例域， 进而搅
		      乱相邻存储空间的内容。
		      为了确保不发生这类错误， 所有数组都要牢记创建它们的元素类型， 并负责监督仅
		      将类型兼容的引用存储到数组中。例如， 使用 new managers[10] 创建的数组是一个经理数组。
		      如果试图存储一个 Employee 类型的引用就会引发 ArrayStoreException 异常。
		 * 
		 */
		Manager[] managers = new Manager[10];
		Employee[] staff = managers;
		staff[0] = new Employee();//编译器编译通过但运行会报java.lang.ArrayStoreException
	}
}


class Employee{
	
	
}

class Manager extends Employee{
	
	
}
