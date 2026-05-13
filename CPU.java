class CPU extends Exartimata{
    double speed;
    int core_numbers;
    String on_board_graphics;
    CPU(int stock,String name,double speed,int core_numbers,String on_board_graphics,String constructor,int year,double price){
        super(stock,name,year,price,constructor);
        this.core_numbers=core_numbers;
        this.on_board_graphics=on_board_graphics;
        this.speed=speed;
    }
    public String toString(){
        return super.toString()+"|\n|CPU's speed: "+speed+" GHz|\n|CPU's cores: "+core_numbers+"|\n|Has on board-graphics: "+on_board_graphics+"|";
    }
    public double getDiscountPrice(double oldprice){
        return super.getDiscountPrice(oldprice);
    }//getDiscountPrice
    double getSpeed(){
        return speed;
    }
    int getCores(){
        return core_numbers;
    }
    String getGraphics(){
        return on_board_graphics;
    }
}
