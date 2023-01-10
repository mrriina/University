import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Symbol symb1 = new Symbol('H');
        Symbol symb2 = new Symbol('e');
        Symbol symb3 = new Symbol('l');
        Symbol symb4 = new Symbol('l');
        Symbol symb5 = new Symbol('o');

        Symbol symb6 = new Symbol('t');
        Symbol symb7 = new Symbol('o');

        Symbol symb8 = new Symbol('m');
        Symbol symb9 = new Symbol('e');

        Word w1 = new Word();
        Word w2 = new Word();
        Word w3 = new Word();

        w1.addSymbol(symb1);
        w1.addSymbol(symb2);
        w1.addSymbol(symb3);
        w1.addSymbol(symb4);
        w1.addSymbol(symb5);

        w2.addSymbol(symb6);
        w2.addSymbol(symb7);

        w3.addSymbol(symb8);
        w3.addSymbol(symb9);

        MyString str = new MyString();
        str.addWord(w1);
        str.addWord(w2);
        str.addWord(w3);

        System.out.println(str.toString());
    }
}

class Symbol {
    private char s;

    public Symbol(char s) {
        this.s = s;
    }

    public char getSymbol() {
        return s;
    }

}

class Word {
    private Vector<Symbol> word = new Vector<>();

    public void addSymbol(Symbol c) {
        word.add(c);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Symbol symb: word)
            str.append(symb.getSymbol());
        return str.toString();

    }
}


class MyString {
    private Vector<Word> string = new Vector<>();

    public void addWord(Word w) {
        string.add(w);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Word w : string) {
            str.append(w.toString());
            str.append(' ');
        }
        return str.toString();
    }
}