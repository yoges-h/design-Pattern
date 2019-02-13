
// here is The code For teh SIngalton design Pattren in java 
// A singalton Design Pattren is one which Uses only One object at a time


// 1 Class-level Member (Eager Initialization Method):

 /* 1 Make constructor private.

 2 Make a private constant static instance (class-member) of this Singleton class.
3 Write a static/factory method that returns the object of the singleton class that we have created as a class-member instance.
4 We can also mark a static member as public to access constant static instance directly. But, I like to access class/instance members via methods only.
5 So, the singleton class is different from a normal Java class in terms of instantiation. For a normal class, we use a constructor, whereas for singleton class we use the getInstance()method.

*/

public class singletonClass {

	private static singletonClass SINGLE_INSTANCE  = NULL;

	private singletonClass(){}

	public static singletonClass getInstance(){

		return SINGLE_INSTANCE;
	}
}


/* 

1 Make constructor as private.
2 Make a private static instance (class-member) of this singleton class. But, DO NOT instantiate it.
3 Write a static/factory method that checks the static instance member for null and creates the instance. At last, it returns an object of the singleton class.*/


public class singletonClass { 

	public static void singletonClass SINGLE_INSTANCE = NULL;

	private singletonClass(){}

	public static singletonClass getInstance(){

		if(SINGLE_INSTANCE == NULL)
		{
			synchronized(singletonClass.class){

				SINGLE_INSTANCE = new singletonClass();

			}
		}
		return SINGLE_INSTANCE;
	}
}

/* Class-level Member (Lazy Initialization with double lock Method):
Here, we run into a problem. Suppose that there are two threads running.
 Both can get inside of the if statement concurrently when the instance is null. 
 Then, one thread enters the synchronized block to initialize the instance, 
 while the other is blocked.
  When the first thread exits in the synchronized block,
   the waiting thread enters and creates another singleton object. 
   Note that when the second thread enters the synchronized block,
    it does not check to see if the instance is non-null.*/

 public class singletonClass{
     private static singletonClass SINGLE_INSTANCE = NULL;
        private singletonClass() {}
    	  public static singletonClass getInstance(){
    		  if(SINGLE_INSTANCE == NULL)
    		  {
                  synchronized(singletonClass.class)
    			  {
                       if(SINGLE_INSTANCE == NULL)
    				  {
    					  SINGLE_INSTANCE = new singletonClass();
    				  }
    			   }
    		 }

    		return SINGLE_INSTANCE;
    	}
    }

   /* 
   By using nested Inner class (Lazy Load method):
In this method is based on the Java Language Specifications (JLS).
 Java Virtual Machine loads static data-members only on-demand. 
 So, here the class SingletonClass loads at first by the JVM. 
 Since there is no static data memberin the class; SingletonClassHolder does not loads or creates SINGLE_INSTANCE.
This will happen only when we invoke getIntance method. 
JLS guaranteed the sequential execution of the class initialization;
 that means thread-safe. So, we actually do not need to provide explicit synchronization on static getInstance() method for loading and initialization.
  Here, since the initialization creates the static variable SINGLE_INSTANCE in a sequential way,
   all concurrent invocations of the getInstance() will return the same correctly initialized SINGLE_INSTANCE without synchronization overhead*/

public class SingletonClass {
    private SingletonClass() {}
    private static class SingletonClassHolder {
        static final Something SINGLE_INSTANCE = new SingletonClass();
    }
    public static SingletonClass getInstance() {
        return SingletonClassHolder.SINGLE_INSTANCE;
    }
}

/* By using Enums:All of the above approaches are not full-proof in all the cases. 
We can still create multiple instances of the above implementations by using serialization
 or reflection. In both of the cases, we can bypass the private constructor and,
  hence, can easily create multiple instances. So, the new approach is to create singleton class by using enums 
  since enums fields are compiled time constants, but they are instances of their enum type. And, they're constructed 
  when the enum type is referenced for the first time.*/

public enum SingletonClass {
    SINGLE_INSTANCE;
}
