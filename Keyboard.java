class Keyboard extends Periferiaka{
    String connection;
    Keyboard(int stock,String name,String connection,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.connection=connection;
    }
    public String toString(){
        return super.toString()+"|\n|Connection: "+connection+"|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getConnection(){
        return connection;
    }
}