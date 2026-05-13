import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;  
class Orders{
    static Scanner in=new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate now = LocalDate.now();
    int order_number=1334456789;
    long customer_phone;
    String product,customer_name,estimated_date,status;
    String order_date=dtf.format(now);
    double total_cost;
    String product_type;
    HashMap<Integer, Orders> OrdersMap = new HashMap<Integer, Orders>();
    void addOrder(Orders info){ //info=antikeimeno tajhs Orders
        OrdersMap.put(order_number,info);
        this.order_number++;
    }
    Orders(String product,String customer_name,String estimated_date,String status,long customer_phone,double total_cost){
        this.product=product;
        this.customer_name=customer_name;
        this.estimated_date=estimated_date;
        this.status=status;
        this.customer_phone=customer_phone;
        this.total_cost=total_cost;
    }
    Orders(){

    }

    void printOrders(){
        if(OrdersMap.size()==0){
            System.out.println("THERE ARE NO ORDERS, GOING BACK TO MAIN MENU...");
        }
        else{
            int count=1;
            System.out.println("\n\nORDERS' LIST\n***************");
            for(int i: OrdersMap.keySet()){
                System.out.println((count++)+". ORDER ID: "+i);
            }
        }
    }
    int print_speciefic_order(){
        int answer=-1;
        if(OrdersMap.size()!=0){
            System.out.println("\n\nWhich order do you wanna see?(TYPE THE ORDER'S CODE)");
            System.out.print("\n> ");
            answer = in.nextInt(); // PRODUCT KEY
            while(OrdersMap.get(answer)==null){
                System.out.println("\n\nPlease enter an existing order id!");
                System.out.print("\n> ");
                answer = in.nextInt();
            }
            System.out.println(OrdersMap.get(answer));
        }
        return answer;
    }


    public String toString(){
        return "\nORDER'S DETAILS\n***************\n|PRODUCT NAME: "+product+"|\n|Customer's Name: "+customer_name+"|\n|Customer's phone: "+ customer_phone+"|\n|Status: "+status+"|\n|Final Price: "+total_cost+" $|\n|ORDER DATE: "+ order_date+"|\n|ESTIMATED ARRIVAL DATE: "+estimated_date+"|";
    }


    boolean wrongDate(String user_date){
        if(user_date.equals(order_date)){
            return user_date.equals(order_date);
        }
        else{
            int days=Integer.parseInt(Integer.toString(user_date.charAt(0)-48)+Integer.toString(user_date.charAt(1)-48));
            int months=Integer.parseInt(Integer.toString(user_date.charAt(3)-48)+Integer.toString(user_date.charAt(4)-48));
            int years=Integer.parseInt(Integer.toString(user_date.charAt(6)-48)+Integer.toString(user_date.charAt(7)-48)+Integer.toString(user_date.charAt(8)-48)+Integer.toString(user_date.charAt(9)-48));
            int days1=Integer.parseInt(Integer.toString(order_date.charAt(0)-48)+Integer.toString(order_date.charAt(1)-48));
            int months1=Integer.parseInt(Integer.toString(order_date.charAt(3)-48)+Integer.toString(order_date.charAt(4)-48));
            int years1=Integer.parseInt(Integer.toString(order_date.charAt(6)-48)+Integer.toString(order_date.charAt(7)-48)+Integer.toString(order_date.charAt(8)-48)+Integer.toString(order_date.charAt(9)-48));
            if(years<years1){
                return true;
            }
            else if(years>years1){
                return false;
            }
            else{
                if(months<months1){
                    return true;
                }
                else if(months>months1){
                    return false;
                }
                else{
                    if(days<=days1){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
    }
    Sales updateOrderToSale(int orderid){
        OrdersMap.get(orderid).status="Completed";
        return new Sales(OrdersMap.get(orderid).product,OrdersMap.get(orderid).customer_name,OrdersMap.get(orderid).customer_phone,OrdersMap.get(orderid).total_cost); //kanei return to neo antikeimeno Sale
    }
    void readOrders(){
        int id=0;
        String type="";
        String model="";
        String name="";
        long phone=0;
        String date="";
        double price=0;
        String est_date="";
        String status="";
        //
        BufferedReader reader = null;
        Products product = null;
        String line;
        System.out.println("\n >>>>>>> Adding ORDERS  from File to List ...");
        try {
            reader = new BufferedReader(new FileReader(new File("orders.txt")));
            line = reader.readLine();
            if(line!=null)
            if (line.trim().equals("ORDERS_LIST")) {  //SKIP ORDER_LIST
                line=reader.readLine();
                if(line.trim().equals("{")){ //SKIP {
                   line=reader.readLine();
                }
            }
            while (line != null) {
                if (line.trim().toUpperCase().equals("ORDER")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        int counter=0;
                        while (counter<9){
                             line = reader.readLine();
                        
                            if (line.trim().toUpperCase().startsWith("NUMBER ")) {
                                id=Integer.parseInt(line.substring(8).trim());
                                line = reader.readLine();
                                 counter++;
                            if (line.trim().toUpperCase().startsWith("ITEM_TYPE "))
                                type=line.substring(11).trim();
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("MODEL "))
                                model=line.substring(7).trim();
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("NAME "))
                                name=line.substring(6).trim();
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("PHONE "))
                                phone=Long.parseLong(line.substring(7).trim());
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("ORDER_DATE "))
                                date=line.substring(12).trim();
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("DELIVERY_DATE "))
                                est_date=line.substring(15).trim();
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("PRICE "))
                                price=Double.parseDouble(line.substring(7).trim());
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("STATUS "))
                                status=line.substring(8).trim();
                                line = reader.readLine();
                                counter++;
                        }
                            if (line.trim().equals("}"))
                                this.order_number=id+1;
                                Orders new_order=new Orders(model,name,est_date,status,phone,price);
                                OrdersMap.put(id,new_order);
                                new_order.updateType(type);
                        } // PRINTERS
                    }
                }//ITEM   
                line = reader.readLine();
            }//WHILE
            reader.close();
        }//TRY
        catch (IOException e) {
            System.out.println	("Error reading line ...");
        }
    }//READ ORDERS   

    void writeOrders(){
        System.out.println(" >>>>>>> Write data from OrdersMap to FILE orders.txt");
		FileWriter writer = null;
		try	{
			writer = new FileWriter(new File("orders.txt"));
            writer.write("ORDER_LIST\n{\n");
			for (int i: OrdersMap.keySet()){
				writer.write ("\tORDER"+"\n"+"\t{"+"\n"+"\t\t"+"NUMBER "+i+"\n"+"\t\t"+"ITEM_TYPE "+OrdersMap.get(i).getType()
						    + "\n"+"\t\t"+"MODEL "+ OrdersMap.get(i).getProduct()
							+ "\n"+"\t\t"+"NAME "	+ OrdersMap.get(i).getName()
							+ "\n"+"\t\t"+"PHONE "	+ OrdersMap.get(i).getPhone()
							+ "\n"+"\t\t"+"ORDER_DATE " +OrdersMap.get(i).getDate()
                            + "\n"+"\t\t"+"DELIVERY_DATE " + OrdersMap.get(i).getEstDate()
                            + "\n"+"\t\t"+"PRICE " + OrdersMap.get(i).getPrice()
                            + "\n"+"\t\t"+"STATUS " + OrdersMap.get(i).getStatus()
							+ "\n"+"\t}"+"\n");
		    }//for
            writer.write("\n}");
            writer.close();
        }//try
		catch (IOException e) {
			System.err.println("Error writing file.");
		}
    }

    String getStatus(){
        return status;
    }

    String getProduct(){
        return product;
    }
    String getName(){
        return customer_name;
    }
    long getPhone(){
        return customer_phone;
    }
    String getDate(){
        return order_date;
    }
    String getEstDate(){
        return estimated_date;
    }
    double getPrice(){
        return total_cost;
    }

    void updateType(String product_type){
        this.product_type=product_type;
    }

    String getType(){
        return this.product_type;
    }
}