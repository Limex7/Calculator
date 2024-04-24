import java.lang.Math;
public class BoringOperators {
    private int a;
    private int b;

    public BoringOperators(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void setA(int A){
        a = A;
    }
    public void setB(int B){
        b = B;
    }
    public int sub(){
        return a - b;
    }
    public int add(){
        return a + b;
    }
    public int mul(){
        return a * b;
    }
    public int div(){
        return a/b;
    }
    public int exp(){
        if ((int) Math.pow(a,b) == 2147483647){
            throw new IllegalArgumentException("to big of a number"); //we'll fix this later just need to do something with like 2.147 * 10^9 or something
        }
        return (int) Math.pow(a, b);
    }

}
