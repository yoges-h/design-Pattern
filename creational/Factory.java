
/*
Factory design pattern is used when we have a super class with multiple sub-classes 
and based on input, we need to return one of the sub-class.
 This pattern take out the responsibility of instantiation of a class from client program 
 to the factory class. */
package com.journaldev.design.factory;

 public abstract class Computer{


 	public abstract String getRAM();
 	public abstract String getHDD();
 	public abstract String getCPU();

 	@Override

 public String toString(){

		return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();

 }

}

// Factory Design Pattren Sub Classes.
// Let’s say we have two sub-classes PC and Server with below implementation.


public class PC extends Computer{

	private String ram;
	private String hdd;
	private String cpu;


	public PC(String ram, String hdd, String cpu)
	{
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;

	}

	@Override

	public String getRam(){

		return this.ram;

	}

	public String getHDD()
	{
		return this.hdd;
	}

	public 	String getCPU()
	{
		return this.cpu;
	}
}


public class Server extends Computer{

	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	Override
	public String getCPU() {
		return this.cpu;
	}

}

/* Now that we have super classes and sub-classes ready, 
we can write our factory class. 
Here is the basic implementation.*/

package com.journaldev.design.factory;

import com.journaldev.design.model.Computer;
import com.journaldev.design.model.PC;
import com.journaldev.design.model.Server;


public class computerFactory{

	public static Computer getComputer(String type, String ram, String hdd, String cpu)
	{

		if("PC".equalsIgnorecase(type)) return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
    
    return NULL;
	}
}

// This program Uses Above Defined factory Methods

package com.journaldev.design.test;
import com.journaldev.design.factory.ComputerFactory;
import com.journaldev.design.model.Computer;

public class TestFactory {

	public static void main(String[] args) {

		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}

}
/* 
1 Factory Design Pattern Advantages

1 Factory design pattern provides approach to code for interface rather than implementation.
2 Factory pattern removes the instantiation of actual implementation classes from client code. 
Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
 3Factory pattern provides abstraction between implementation and client classes through inheritance.
 */