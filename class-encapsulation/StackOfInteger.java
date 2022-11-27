public class StackOfInteger {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    //constructors
    public StackOfInteger(){
        this(DEFAULT_CAPACITY);
    }

    public StackOfInteger(int capacity){
        elements = new int[capacity];
    }

    public void push(int value){
        if (size >= elements.length){
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0 , temp, 0, elements.length);
            elements = temp;
        }

        elements[size++] = value;
    }

    public int pop(){
        return elements[--size];
    }

    public boolean empty(){
        return size == 0;
    }
}

class DisplayPrimeNumbers{
    public static void main(String[]args){
        String display;
        //create an object
        StackOfInteger primeList = new StackOfInteger();
        //find the prime numbers
        for (int i = 2; i <= 120; i++){
            if (isPrime(i))
                primeList.push(i);
        }

        //display the result
        while(!primeList.empty()){
            System.out.print(primeList.pop() + " ");
        }
    }
    //examine whether the number is a prime number
    public static boolean isPrime(int num){
        boolean isPrime = true;
        for (int i = 2; i < num; i++){
            if (num != 3 && num % i == 0){
                isPrime = false; break;
            }

        }
        return isPrime;
    }
}
