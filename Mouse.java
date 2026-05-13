class Mouse extends Periferiaka{
    String technology,connection;
    Mouse(int stock,String name,String technology,String connection,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.technology=technology;
        this.connection=connection;
    }
    public String toString(){
        return super.toString()+"|\n|Technology: "+technology+"|\n|Connection: "+connection+"|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getConnection(){
        return connection;
    }
    String getTechnology(){
        return technology;
    }
}
