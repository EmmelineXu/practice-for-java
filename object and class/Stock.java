public class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;


    Stock(){
    }
    Stock(String newSymbol, String newName){
        symbol = newSymbol;
        name = newName;
    }

    void setPreviousClosingPrice(double newPreviousClosingPrice){
        previousClosingPrice = newPreviousClosingPrice;
    }
    void setCurrentPrice(double newCurrentPrice){
        previousClosingPrice = newCurrentPrice;
    }

    double getPreviousClosingPrice(){
        return previousClosingPrice;
    }
    double getCurrentPrice(){
        return currentPrice;
    }
    double getChangePercent(){
        return (currentPrice- previousClosingPrice) / previousClosingPrice;
    }

}

class TestStock{
    public static void main(String[]args){
        Stock object1 = new Stock("ORCL", "Oracle Corporation");
        object1.previousClosingPrice = 34.5;
        object1.currentPrice = 34.45;
        System.out.println(object1.getChangePercent());
    }
}