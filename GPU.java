class GPU extends Exartimata{
    String chipset;
    int memory;
    GPU(int stock,String name,String chipset,int memory,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.chipset=chipset;
        this.memory=memory;
    }

    public String toString(){
        return super.toString()+"|\n|Chipset: "+chipset+"|\n|Memory: "+memory+"|";
    }

    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getChipset(){
        return chipset;
    }
    int getMemory(){
        return memory;
    }
}
