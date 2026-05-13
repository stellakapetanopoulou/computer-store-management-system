import java.util.*;
abstract class Periferiaka extends Products{
    private double discount=0.1;

    Periferiaka(int stock,String name,int year,double price,String constructor){
        super(stock,name,year,price,constructor);
    }//Constructor

    public String toString(){
        return super.toString()+"---|Discount percentage: 10%"+"---|Discount amount: "+(Math.round((discount*price*100.0))/100.0)+"$--->|FINAL PRICE: "+ (Math.round((price-discount*price)*100.0)/100.0)+"$";
    }//toString

    public double getDiscountPrice(double oldprice){
        return (oldprice-discount*oldprice);
    }//getDiscountPrice
}