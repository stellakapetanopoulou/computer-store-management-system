class Harddrive extends Exartimata{
    String type,capacity;
    double size;
    Harddrive(int stock,String name,String type,String capacity,double size,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.type=type;
        this.capacity=capacity;
        this.size=size;
    }
    public String toString(){
        return super.toString()+"|\n|Type: "+type+"|\n|Capacity: "+capacity+"|\n|Size: "+size+"|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getType(){
        return type;
    }
    String getCapacity(){
        return capacity;
    }
    double getSize(){
        return size;
    }
}
