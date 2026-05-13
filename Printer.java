class Printer extends Periferiaka{
    String technology,type;
    Printer(int stock,String name,String technology,String type,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.type=type;
        this.technology=technology;
    }

    public String toString(){
        return super.toString()+"|\n|Technology: "+technology+"|\n|Type: "+type+"|";
    }

    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice

    String getTechnology(){
        return technology;
    }
    String getType(){
        return type;
    }
}