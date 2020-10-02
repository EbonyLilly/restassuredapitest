package commons;

public class Printer {
    public Printer printGreeting(){
        System.out.println("printingGreeting:   Hello");
        return this;
    }
    public Printer printFavoriteNum(){
        System.out.println("printFavoriteNum:   My favorite number is 555");
        return this;

    }

    public Printer printColor(){
        System.out.println("printerColor:     Green");
        return this;
    }
}
