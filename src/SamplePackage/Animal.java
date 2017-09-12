package SamplePackage;

public class Animal 
{

	private static String name="Harish";
	int i=10;
	
	
	static String   test()
	{
		String a=name;
		return a;
	}
	Animal()
	{
		this("hello");
		System.out.println("A"); //from 1st calling 2nd constructor
	}
	
	Animal(String s)    //2nd constructor overloaded with string parameter
	{
		System.out.println(s);
	}
	
	
	Animal(int i)
	{
		this();   // from 3rd calling 1st
		
		System.out.println(i);
	}

	static String display()
	{
		
		System.out.println("Say Welcome");
		 String k="abc";
		 return k;
	}
	
	/*public static void main(String[] args)
	{
		Animal a=new Animal(2);  //calling 3rd constructor
	}
	
	*/
	
	
	void eat()
	{
		
		System.out.println("eating");
	}
}
