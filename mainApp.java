import java.util.*;
import java.io.*;
class mainApp{
    //ORISMOS XRISIMWN DEDOMENWN
    static Sales sales=new Sales(); //Lista Pwlhsewn
    static Orders orders=new Orders(); //Lista paraggeliwn
    static ProductList ob=new ProductList(); //Lista proiontwn
    static String answer;
    static Scanner in=new Scanner(System.in);
    static boolean done=false;
    static int item_stock;
    static String item_name;
    static double item_price;
    static Products item;
    //TELOS ORISMOU -------- static gt xrisimopoiountai mesa se klaseis p briskontai sth main
    static String Menu(){ //BASIKO MENU
   		System.out.println("\n MAIN MENU\n*************");
 	    System.out.println("1. VIEW THE PRODUCTS");   		
        System.out.println("2. VIEW ALL THE ORDERS");
        System.out.println("3. VIEW ALL THE PURCHASES");
		System.out.println("0. EXIT");
 		System.out.print("\n> ");
        answer = in.nextLine();
        if(answer.equals("0")) done=true;
        return answer;
    }
    static String Menu_proiontwn(){ //AMESWS META TO BASIKO MENU
            System.out.print("WHAT KIND OF PRODUCT DO YOU WANT?");
            System.out.println("\n1. PERIPHERALS");
   	 		System.out.println("2. COMPUTER PARTS");
            System.out.println("0. BACK");
            System.out.print("\n> ");
            answer=in.nextLine();
            return answer;
            
    }
    static String Menu_periferiakwn(){
        System.out.println("1. Printers");
        System.out.println("2. Keyboards");
        System.out.println("3. Screens");
        System.out.println("4. Mouse");
        System.out.println("0. Back");
        System.out.print("\n> ");
        answer=in.nextLine(); // Epilogh kathgorias periferiakou
        return answer;
    }

    static String Menu_parts(){
        System.out.println("1. Motherboards");
        System.out.println("2. CPUs");
        System.out.println("3. RAMs");
        System.out.println("4. GPUs");
        System.out.println("5. Hard-drives");
        System.out.println("0. Back");
        System.out.print("\n> ");
        answer=in.nextLine();
        return answer;
    }

    static String menu_group_peripherals(){
        if(answer.equals("1")){
            answer="Printer";
        }
        else if(answer.equals("2")){
            answer="Keyboard";
        }
        else if(answer.equals("3")){
            answer="Screen";;
        }
        else if(answer.equals("4")){
            answer="Mouse";
        }
        ob.print_in_stock(answer);
        System.out.println("0. Back");
        System.out.print("Which product do you want?\n> ");
        answer=in.nextLine();
        while(Integer.parseInt(answer)>ob.lengthIndex()){
            System.out.println("Please pick an existing item!!!");
            System.out.print("\n> ");
            answer=in.nextLine();  
        }
        return answer;
    }

    static String menu_group_parts(){
        if(answer.equals("1")){
            answer="Motherboard";
        }
        else if(answer.equals("2")){
            answer="CPU";
        }
        else if(answer.equals("3")){
            answer="RAM";
        }
        else if(answer.equals("4")){
            answer="GPU";
        }
        else if(answer.equals("5")){
            answer="Harddrive";
        }
        ob.print_in_stock(answer);
        System.out.println("0. Back");
        System.out.print("Which product do you want?\n> ");
        System.out.print("\n> ");
        answer=in.nextLine();
        while(Integer.parseInt(answer)>ob.lengthIndex()){
            System.out.println("Please pick an existing item!!!");
            System.out.print("\n> ");
            answer=in.nextLine();  
        }
        return answer;
    }

    static String speciefic_products(){ //KOINH ME8ODOS GIA PERIPHERALS KAI PARTS
        ob.print_speciefic_products(ob.getIndex(Integer.parseInt(answer)-1));
        item_stock=ob.getStock(ob.getIndex(Integer.parseInt(answer)-1)); //item stock
        item_name=ob.getName(ob.getIndex(Integer.parseInt(answer)-1)); //item name
        item_price= ob.getPrice(ob.getIndex(Integer.parseInt(answer)-1));//old item price
        item=ob.getObject(ob.getIndex(Integer.parseInt(answer)-1)); //the entire object of the item
        double final_price=item.getDiscountPrice(item_price); //briskei discounted price
        
        ob.clearIndex(); // ka8e fora p typonontai ta antikeimena kai epilegei sbhnetai h lista me tous index gia na ananew8ei gia ta epomena(index=h 8esh to arraylist pou brisketai to antikeimeno p epeleje o xrhsths)
        if(item_stock==0){
            System.out.println("\nITEM OUT OF STOCK, MAKE AN ORDER?\n");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("\n> ");
            answer=in.nextLine(); 
        }
        else{
            answer="3"; // PURCHASE NOW OPTION
        }
        return answer;
    }

    static void make_order(){
        System.out.println("Name? ");
        System.out.print("\n> ");
        String name=in.nextLine();
        System.out.println("Estimated arrival date?\nGIVE THE DATE IN THIS FORM: dd-MM-yyyy");
        System.out.print("\n> ");
        String estimated_date=in.nextLine();
        while(orders.wrongDate(estimated_date)){
            System.out.println("WRONG DATE, GIVE ANOTHER ONE!");
            System.out.print("\n> ");
            estimated_date=in.nextLine();
        }
        System.out.println("Phone? ");
        System.out.print("\n> ");
        long phone=Long.parseLong(in.nextLine());
        Orders new_order=new Orders(item_name,name,estimated_date,"Incompleted",phone,item_price);
        new_order.updateType(ob.findType(item_name));
        orders.addOrder(new_order); //adding new order at orders HashMap
        System.out.println("\n\n\n\nYOUR ORDER HAS BEEN COMPLETED, RETURNING TO THE MAIN MENU...\n\n\n\n");
    }

    static void make_purchase(){
        System.out.println("\nITEM IS AVAILABLE, PURCHASE NOW!");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("\n> ");
        answer=in.nextLine();
        if(answer.equals("1")){
            System.out.println("Name? ");
            System.out.print("\n> ");
            String name=in.nextLine();
            System.out.println("Phone? ");
            System.out.print("\n> ");
            long phone=Long.parseLong(in.nextLine());
            item.stock-=1;
            Sales new_sale=new Sales(item_name,name,phone,item_price);
            new_sale.updateType(ob.findType(item_name));
            sales.addSale(new_sale);
            System.out.println("\n\n\n\nYOUR PURCHASE HAS BEEN COMPLETED, RETURNING TO THE MAIN MENU...\n\n\n\n");
        }
    }
    
    //MAIN
    public static void main(String args[]){
        
        
 //READING sales.txt
        sales.readSales(); //READING sales.txt
        orders.readOrders(); //READING  order.txt
        ob.ReadProductFile(); //READING products.txt 
        System.out.println("\n\nWelcome to our e-shop!");
        do{ //ARXH MENU
            Menu();
            if (answer.equals ("1")){ //apanthsh sto basiko menu, 1-> ORDER A PRODUCT 2->VIEW ORDERS 3->VIEW PURCHASES 0->exit
   	 			do{
                    Menu_proiontwn(); //META APO THN EKTELESH MIAS MENU ME8ODOU, TO ANSWER ANANEWNETAI KAI ELEGXETAI EK NEOU!!!
                    if(answer.equals("1")){  //PERIFERIAKA
                        do{
                            Menu_periferiakwn(); // 1-4 Printers-Mouse
                            if(!answer.equals("0")){
                                do{ 
                                    menu_group_peripherals();
                                    if(!answer.equals("0")){
                                        speciefic_products();
                                        do{
                                        if(answer.equals("1")){
                                            make_order();
                                            answer="0"; //answer=0 gia na spasei to break
                                            break;
                                        }
                                        else if(answer.equals("2")){
                                            answer="0";
                                            break;
                                        }
                                        else if(answer.equals("3")){
                                            make_purchase();
                                            answer="0";
                                            break;
                                        }
                                        }while(!answer.equals("0"));
                                    } 
                                    else{
                                        ob.clearIndex(); 
                                        answer="none";
                                        break;
                                    }
                                }while(!answer.equals("0"));
                            }
                            else{
                                answer="none";
                                break;
                            }
                        }while(!answer.equals("0"));
                    }
                    else if(answer.equals("2")){ //PARTS
                        do{
                            Menu_parts(); // 1-5 Motherboard-Harddrives
                            if(!answer.equals("0")){
                                do{ 
                                    menu_group_parts(); //LISTA PROIONTOS KATHGORIAS (PX OLA TA CPU)
                                    if(!answer.equals("0")){
                                        speciefic_products();
                                        do{
                                        if(answer.equals("1")){
                                            make_order();
                                            answer="0"; //answer=0 gia na spasei to break
                                            break;
                                        }
                                        else if(answer.equals("2")){
                                            answer="0";
                                            break;
                                        }
                                        else if(answer.equals("3")){
                                            make_purchase();
                                            answer="0";
                                            break;
                                        }
                                        }while(!answer.equals("0"));
                                    } 
                                    else{
                                        ob.clearIndex();
                                        answer="none";
                                        break;
                                    }
                                }while(!answer.equals("0"));
                            }
                            else{
                                answer="none";
                                break;
                            }
                        }while(!answer.equals("0"));
                    }
                    else if(answer.equals("0")){
                        answer="none";
                        break;
                    }
                } while(!answer.equals("0"));
            }//APANTHSH=1
            else if(answer.equals("2")){ //VIEW ORDERS
                orders.printOrders();
                int key=orders.print_speciefic_order(); 
                if(orders.OrdersMap.size()>0){
                    System.out.println("Did you recieve your product?\n1. Yes\n2. No\n3. Already answered!!!");
                    System.out.print("\n> ");
                    String answer1 = in.nextLine();
                    if (answer1.equals("1")){
                        Sales newsale=orders.updateOrderToSale(key);
                        sales.addSale(newsale); //adding sale
                    }
                    else if(answer1.equals("2")){
                        System.out.println("Be patient, you will receive your order soon!!");
                    }
                }
            }//APANTHSH=2
            else if(answer.equals("3")){ //VIEW PURCHSASES
                sales.printSales();
                sales.print_speciefic_sale();
            }//APANTHSH=3
   	 	} while(!done); //TELOS MENU
        orders.writeOrders(); //WRITE orders at order.txt
        sales.writeSales();
    }//MAIN
}


