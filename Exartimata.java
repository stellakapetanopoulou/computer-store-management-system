import java.util.*;
abstract class Exartimata extends Products{
    private double discount=0.25;

    Exartimata(int stock,String name,int year,double price,String constructor){
        super(stock,name,year,price,constructor);
    }//Constructor

    public String toString(){
        return super.toString()+"---Discount percentage: 25%"+"---Discount amount: "+(Math.round((0.25*price*100.0))/100.0)+"$--->|FINAL PRICE: "+(Math.round((price-0.25*price)*100.0)/100.0)+"$";
    }//toString

    public double getDiscountPrice(double oldprice){
        return (oldprice-discount*oldprice);
    }//getDiscountPrice

}