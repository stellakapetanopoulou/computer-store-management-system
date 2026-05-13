class Screen extends Periferiaka{
    String type,resolution,ports;
    double size;
    Screen(int stock,String name,String type,String resolution,String ports,double size,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.type=type;
        this.resolution=resolution;
        this.ports=ports;
        this.size=size;
    }
    public String toString(){
        return super.toString()+"|\n|Type: "+type+"|\n|Ports: "+ports+"|\n|Resolution: "+resolution+"|\n|Size: "+size+" inches|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getScreenType(){
        return type;
    }
    double getDimensions(){
        return size;
    }
    String getInterfaces(){
        return ports;
    }
    String getResolution(){
        return resolution;
    }
}