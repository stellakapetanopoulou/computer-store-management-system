class Motherboard extends Exartimata{
    String cpu_type;
    int memory, sockets;
    Motherboard(int stock,String name,String cpu_type,int memory,int sockets,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.cpu_type=cpu_type;
        this.memory=memory;
        this.sockets=sockets;
    }
    public String toString(){
        return super.toString()+"|\n|CPU type: "+cpu_type+"|\n|Memory: "+memory+" GB |\n|Number of sockets: "+sockets+"|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    String getCpuType(){
        return cpu_type;
    }
    int getMemory(){
        return memory;
    }
    int getSockets(){
        return sockets;
    }
}