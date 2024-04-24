public class BoringOperators {
    private int a;
    private int b;

    public BoringOperators(int a, int b){
        this.a = a;
        this.b = b;
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
        return a**b;
    }

}
