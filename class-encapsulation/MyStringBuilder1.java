public class MyStringBuilder1 {

    private String s;

    MyStringBuilder1(){
        this("Java is fun");
    }
    MyStringBuilder1(String s){
        this.s = s;
    }
    public MyStringBuilder1 append(MyStringBuilder1 s) {
        // get the original attribution of s
        String newStr  = this.s;
        newStr += s;
        //return a new object
        return new MyStringBuilder1(newStr);
    }

    public MyStringBuilder1 append(int i) {
        String newStr  = this.s;
        newStr += i + "";
        return new MyStringBuilder1(newStr);
    }

    public int length() {
        return s.length();
    }

    public char charAt(int index) {
        return s.charAt(index);
    }

    public MyStringBuilder1 toLowerCase() {
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + ('a' - 'A'));
            }
            newStr += ch + "";
        }
        return new MyStringBuilder1(newStr);
    }

    public MyStringBuilder1 substring(int begin, int end) {
        String newStr = "";
        for (int i = begin; i < end; i ++) {
            newStr += s.charAt(i) + "";
        }
        return new MyStringBuilder1(newStr);
    }

    public String toString() {
        return s;
    }

}
class TestMyStringBuilder1{
    public static void main(String[]args){
        MyStringBuilder1 myStringBuilder1 = new MyStringBuilder1();
        //test1
        System.out.println(myStringBuilder1.append(myStringBuilder1));
        //test2
        System.out.println(myStringBuilder1.append(2));
        //test3
        System.out.println(myStringBuilder1.length());
        //test4
        System.out.println(myStringBuilder1.charAt(2));
        //test5
          System.out.println(myStringBuilder1.toLowerCase());
        //test6
        System.out.println(myStringBuilder1.substring(0, 6));
        //test7
        System.out.println(myStringBuilder1.toString());
    }
}
