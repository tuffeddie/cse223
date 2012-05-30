package assignment7;

public class Patient {

	public String name;
	public long id;
	public int age;
	public double weight;
	public double height;
	public String condition;
	public int urgencyLevel;
	
	public Patient(int age, double weight, double height){
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	public Patient(String name, int age, double weight, double height){
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	public Patient(String name, int age, double weight, double height, long id, String condition){
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.id = id;
		this.condition = condition;
	}
	
	public String getName(){
		return name;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public int getAge(){
		return age;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public double getHeight(){
		return height;
	}
	
	public void setCondition(String condition){
		this.condition = condition;
	}
	
	public String getCondition(){
		return condition;
	}
	
	public void setUrgencyLevel(int urgencyLevel){
		this.urgencyLevel = urgencyLevel;
	}
	
	public int getUrgencyLevel(){
		return urgencyLevel;
	}
	
 }