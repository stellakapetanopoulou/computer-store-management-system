import java.util.*;
abstract class Products{  //SUPER CLASS
    protected String product_name, constructor;
    protected int year;
    protected double price;
    protected int stock;

    public String toString(){
        return "|Product's name: "+product_name+" "+"|\n|Year: "+year+"|\n|Constructor: "+constructor+"|\n|STOCK: "+stock+"|\n|STARTING PRICE: "+(Math.round(price*100.0)/100.0)+"$";
    }//toString


    Products(int stock,String product_name,int year,double price,String constructor){
        this.stock=stock;
        this.product_name=product_name;
        this.year=year;
        this.price=price;
        this.constructor=constructor;
    }//Constructor
    
    abstract double getDiscountPrice(double oldprice);

    int getYear(){
        return year;
    }
    String getConstructor(){
        return constructor;
    }
    String getName(){
        return product_name;
    }//getName

    double getPrice(){
        return price;
    }//getPrice
    int getStock(){
        return stock;
    }
}
