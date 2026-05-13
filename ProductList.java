import java.util.*;
import java.io.*;
class ProductList{
    private ArrayList<Products> in_stock=new ArrayList<Products>();
    private ArrayList<Integer> index=new ArrayList<Integer>(); //edw krataw ta index twn sygkekrimenwn proiontwn p emfanizontai.

    void print_in_stock(String product_type){ //gia sygkekrimenh kathgoria typwnei ola ta items ths.
        int counter=1;
        for(Products i: in_stock){
            if(i.getClass().getSimpleName()==product_type){ //o typos tou antikeimenou metatrepetai se string
            System.out.println(counter+". "+i.product_name);
            counter++;
            index.add(in_stock.indexOf(i));
            }
        }
        counter=1;    
    }//print_in_stock

    ArrayList<Products> getList(){
        return in_stock;
    }

    void print_speciefic_products(int i){
        System.out.println(in_stock.get(i));
    }//print_specific_products

    void storeProduct(Products product){
        in_stock.add(product);
    }//storeProduct

    int getStock(int i){
        return in_stock.get(i).stock;
    }//getStock

    int getIndex(int i){
        return index.get(i);
    }//getIndex

    void clearIndex(){
        index.clear();
    }//clearIndex

    int lengthIndex(){
        return index.size();
    }//lengthIndex

    String getName(int i){
        return in_stock.get(i).product_name;
    }//getName

    double getPrice(int i){
        return in_stock.get(i).price;
    }//getPrice

    Products getObject(int i){
        return in_stock.get(i);
    }//getObject


    String findType(String name){
        String type="";
        for(Products i: in_stock){
            if(name.equals(i.getName())){
                type=i.getClass().getSimpleName();
            }
        }
        return type;
    }
    
    void ReadProductFile(){
//READING PRODUCTS FILE
            BufferedReader reader = null;
            Products product = null;
            String line;
            System.out.println("\n >>>>>>> Adding Objects (Items) from File to List ...");
            try {
                reader = new BufferedReader(new FileReader(new File("products.txt")));
                line = reader.readLine();
                if (line.trim().equals("ITEM_LIST")) {
                    line=reader.readLine();
                    if(line.trim().equals("{")){
                        line=reader.readLine();
                    }
                }
                while (line != null) {
                    String model="";
                    int year=0;
                    String manufacturer="";
                    double price=0;
                    int stock=0;
                    if (line.trim().equals("ITEM")) {
                        line = reader.readLine();
                        if (line.trim().equals("{")) {
                            line = reader.readLine();
                                if (line.trim().startsWith("ITEM_TYPE PRINTER")) {
                                    String tech="";
                                    String type="";
                                    int counter=0;
                                    while (counter<7){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("TECHNOLOGY "))
                                        tech=line.substring(12).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("TYPE "))
                                        type=line.substring(6).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new Printer(stock,model,tech,type,manufacturer,year,price));
                                } // PRINTERS
                                else if (line.trim().startsWith("ITEM_TYPE KEYBOARD")) {
                                    String connection="";
                                    int counter=0;
                                    while (counter<6){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("CONNECTION "))
                                        connection=line.substring(12).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new Keyboard(stock,model,connection,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE SCREEN")) {
                                    String resolution="";
                                    String ports="";
                                    double size=0;
                                    String type="";
                                    int counter=0;
                                    while(counter<9){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("SCREEN_TYPE "))
                                        type=line.substring(13).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("DIMENSIONS "))
                                        size=Double.parseDouble(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("RESOLUTION "))
                                        resolution=line.substring(12).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("INTERFACES "))
                                        ports=line.substring(12).trim();
                                        line = reader.readLine();     
                                        counter++;  
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new Screen(stock,model,type,resolution,ports,size,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE MOUSE")) {
                                    String connection="";
                                    String tech="";
                                    int counter=0;
                                    while (counter<7){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("CONNECTION "))
                                        connection=line.substring(12).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("TECHNOLOGY "))
                                        tech=line.substring(12).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new Mouse(stock,model,tech,connection,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE MOTHERBOARD")) {
                                    String type="";
                                    int memory=0;
                                    int socket=0;
                                    int counter=0;
                                    while(counter<8){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("CPU_TYPE "))
                                        type=line.substring(10).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MEMORY "))
                                        memory=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("SOCKETS_NUMBER "))
                                        socket=Integer.parseInt(line.substring(16).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new Motherboard(stock,model,type,memory,socket,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE CPU")) {
                                    int cores=0;
                                    String graphics="";
                                    double speed=0;
                                    int counter=0;
                                    while(counter<8){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                    if (line.trim().startsWith("SPEED "))
                                        speed=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("CORES "))
                                        cores=Integer.parseInt(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("ON_BOARD_GRAPHICS "))
                                        graphics=line.substring(19).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new CPU(stock,model,speed,cores,graphics,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE RAM")) {
                                    int memory=0;
                                    String type="";
                                    int frequency=0;
                                    int counter=0;
                                    while(counter<8){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("TYPE "))
                                        type=line.substring(6).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MEMORY "))
                                        memory=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("FREQUENCY "))
                                        frequency=Integer.parseInt(line.substring(11).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new RAM(stock,model,type,memory,frequency,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE GPU")) {
                                    String chipset="";
                                    int memory=0;
                                    int counter=0;
                                    while(counter<7){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("CHIPSET "))
                                        chipset=line.substring(9).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MEMORY "))
                                        memory=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new GPU(stock,model,chipset,memory,manufacturer,year,price));
                                }
                                else if (line.trim().startsWith("ITEM_TYPE HARDDRIVE")) {
                                    String type="";
                                    String capacity="";
                                    double size=0;
                                    int counter=0;
                                    while(counter<8){
                                    line = reader.readLine();
                                    if (line.trim().startsWith("MODEL "))
                                        model=line.substring(7).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MODEL_YEAR "))
                                        year=Integer.parseInt(line.substring(12).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("MANUFACTURER "))
                                        manufacturer=line.substring(14).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PRICE "))
                                        price=Double.parseDouble(line.substring(7).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("TYPE "))
                                        type=line.substring(6).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("CAPACITY "))
                                        capacity=line.substring(10).trim();
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("SIZE "))
                                        size=Double.parseDouble(line.substring(6).trim());
                                        line = reader.readLine();
                                        counter++;
                                    if (line.trim().startsWith("PIECES "))
                                        stock=Integer.parseInt(line.substring(8).trim());
                                        line = reader.readLine();
                                        counter++;
                                    }
                                    if (line.trim().equals("}"))
                                        in_stock.add(new Harddrive(stock,model,type,capacity,size,manufacturer,year,price));
                                }
                            //TELOS OLWN TWN TYPWN PROIONTWN
                            }
                        }//ITEM
                        line = reader.readLine();
                    } //While
                    reader.close();  
                }//Try 
        catch (IOException e) {
            System.out.println	("Error reading line ...");
        }
    }
}
