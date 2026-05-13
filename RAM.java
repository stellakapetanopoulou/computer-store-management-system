class RAM extends Exartimata{
    String type;
    int memory_size, frequency;
    RAM(int stock,String name,String type,int memory_size,int frequency,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.memory_size=memory_size;
        this.frequency=frequency;
        this.type=type;
    }
    public String toString(){
        return super.toString()+"|\n|Type: "+type+"|\n|Memory size: "+memory_size+" GB|\n|Frequency: "+frequency+" MHz|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getType(){
        return type;
    }
    int getMemory(){
        return memory_size;
    }
    int getFrequency(){
        return frequency;
    }
}