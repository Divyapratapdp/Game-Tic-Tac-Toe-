package tic;

public class Player {
    private String Name;
    private char symbol;

    public Player(String name, char symbol) {
        setName(name);
        setSymbol(symbol);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        if (symbol != '\0') {
            this.symbol = symbol;
        }
    }
}
