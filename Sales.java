import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;  
class Sales{
    static Scanner in=new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate now = LocalDate.now();
    String sale_date=dtf.format(now);
    int sale_code;
    String product,name;
    double total_cost;
    long customer_phone;
    String product_type;
    int sale_number=98765432;
    HashMap<Integer, Sales> SalesMap = new HashMap<Integer, Sales>();
    void addSale(Sales info){ //info=antikeimeno tajhs Sales
        this.sale_number++;
        SalesMap.put(sale_number,info);
    }
    Sales(String product,String customer_name,long customer_phone,double total_cost){
        this.product=product;
        this.name=customer_name;
        this.total_cost=total_cost;
        this.customer_phone=customer_phone;
    }
    Sales(){

    }

    void updateType(String product_type){
        this.product_type=product_type;
    }

    String getType(){
        return product_type;
    }
    void printSales(){
        if(SalesMap.size()==0){
            System.out.println("THERE ARE NO PURCHASES, GOING BACK TO MAIN MENU...");
        }
        else{
            int count=1;
            System.out.println("\n\nPURCHASES' LIST\n***************");
            for(int i: SalesMap.keySet()){
                System.out.println((count++)+". SALE ID: "+i);
            }
        }
    }
    public String toString(){
       return "\nPURCHASE'S DETAILS\n***************\n|PRODUCT NAME: "+product+"|\n|Customer's Name: "+name+"|\n|Customer's phone: "+ customer_phone+ "|\n|Total cost: "+total_cost+" $|\n|SALE DATE: "+ sale_date+"|";
    }

     void print_speciefic_sale(){
        if(SalesMap.size()!=0){
            System.out.println("\n\nWhich purchase do you wanna see?(TYPE THE PURCHASE'S CODE)");
            System.out.print("\n> ");
            int answer = in.nextInt(); // PRODUCT KEY
            while(SalesMap.get(answer)==null){
                System.out.println("\n\nPlease enter an existing sale id!");
                System.out.print("\n> ");
                answer = in.nextInt();
            }
            System.out.println(SalesMap.get(answer));
        }
    }


    void readSales(){
        int id=0;
        String type="";
        String model="";
        String name="";
        long phone=0;
        String date="";
        double price=0;
        //
        BufferedReader reader = null;
        Products product = null;
        String line;
        System.out.println("\n >>>>>>> Adding SALES  from File to List ...");
        try {
            reader = new BufferedReader(new FileReader(new File("sales.txt")));
            line = reader.readLine();
            if (line.trim().toUpperCase().equals("SALES_LIST")) {  //SKIP ORDER_LIST
                line=reader.readLine();
                if(line.trim().equals("{")){ //SKIP {
                   line=reader.readLine();
                }
            }
            while (line != null) {
                if (line.trim().toUpperCase().equals("SALE")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        int counter=0;
                        while(counter<7){
                        line = reader.readLine();
                        if (line.trim().toUpperCase().startsWith("NUMBER ")) {
                            id=Integer.parseInt(line.substring(8).trim());
                            line = reader.readLine();
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
                            if (line.trim().toUpperCase().startsWith("SALE_DATE "))
                                date=line.substring(11).trim();
                                line = reader.readLine();
                                counter++;
                            if (line.trim().toUpperCase().startsWith("PRICE "))
                                price=Double.parseDouble(line.substring(7).trim());
                                line = reader.readLine();
                                counter++;
                        }
                            if (line.trim().equals("}"))
                                this.sale_number++;
                                SalesMap.put(id,new Sales(model,name,phone,price));
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

    void writeSales(){
            System.out.println(" >>>>>>> Write data from SalesMap to FILE sales.txt");
            FileWriter writer = null;
            try	{
                writer = new FileWriter(new File("sales.txt"));
                writer.write("SALE_LIST\n{\n");
                for (int i: SalesMap.keySet()){
                    writer.write ("\tSALE"+"\n"+"\t{"+"\n"+"\t\t"+"NUMBER "+i+"\n"+"\t\t"+"ITEM_TYPE "+SalesMap.get(i).getType()
                                + "\n"+"\t\t"+"MODEL "+ SalesMap.get(i).getProduct()
                                + "\n"+"\t\t"+"NAME "	+ SalesMap.get(i).getName()
                                + "\n"+"\t\t"+"PHONE "	+ SalesMap.get(i).getPhone()
                                + "\n"+"\t\t"+"SALE_DATE " +SalesMap.get(i).getDate()
                                + "\n"+"\t\t"+"PRICE " + SalesMap.get(i).getPrice()
                                + "\n"+"\t}"+"\n");
                }//for
                writer.write("\n}");
                writer.close();
            }//try
            catch (IOException e) {
                System.err.println("Error writing file.");
            }
    }// writeSales()

    String getProduct(){
        return product;
    }
    String getName(){
        return name;
    }
    long getPhone(){
        return customer_phone;
    }
    String getDate(){
        return sale_date;
    }
    double getPrice(){
        return total_cost;
    }
}