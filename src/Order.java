// @authors
//Nitika Saran 2014068
//Ishita Verma 2014051

public class Order {
	String id;
	String [] items = new String[50];
	int num=0;
	String status;
	static String [] stats = {"Order Placed","Preparation","Bake","Out for Delivery","Delivered"};
	String name;
	String mobile;
	String address;
	
	Order(String i){
		id =i;
	}
	
	void increment(){
		for (int i = 0; i < 4; i++) {
			if(stats[i].equals(status)){
				System.out.println(i);
				status = stats[i+1];
				break;
			}
		}
	}
	
	void additem(String type,String size,int quantity){
		items[num++]= quantity + "-" + size + "-" + type; 
	}
}
