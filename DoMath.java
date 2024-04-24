import java.util.ArrayList;
public class DoMath{
    private static String Math;

    public DoMath(String Math){
        this.Math = Math;
    }

    public static ArrayList<String> doOrder(){
        ArrayList<String> order = new ArrayList<String>();
        String number = "";
        for (int i = 0; i < Math.length(); i++){
            String sub = Math.substring(i, i+1);
            switch (sub){
                case "-":
                    order.add(number.trim());
                    number = "";
                    order.add("s");
                    break;
                case "+":
                    order.add(number.trim());
                    number = "";
                    order.add("a");
                    break;
                case "*":
                    order.add(number.trim());
                    number = "";
                    order.add("m");
                    break;
                case "/":
                    order.add(number.trim());
                    number = "";
                    order.add("d");
                    break;
                case "^":
                    order.add(number.trim());
                    number = "";
                    order.add("e");
                    break;
                default:
                    number += sub;
                    break;
            }
        }
        order.add(number.trim()); // this adds the last number 
        System.out.println(order);
        return order;
    }

    public static int makeMath(ArrayList<String> order){
        String findMode = "";
        BoringOperators bor = new BoringOperators(0, 0);
        Integer ans = 0;
        double answer = 0;
        while (order.contains("e") || order.contains("m") || order.contains("d") || order.contains("a") || order.contains("s")){
            if (order.contains("e")){
                findMode = "ee"; //making it two long so that i can take more meaning for the other two
            }
            else if (order.contains("d") || order.contains("m")){
                findMode = "dm"; 
            }
            else{
                findMode = "as";
            }
            System.out.println(order);
            for (int j = 0; j < order.size(); j++){ // to find all of the operators in the calc
                if (order.get(j).equals(findMode.substring(0, 1))){
                    bor.setA(Integer.parseInt(order.get(j-1)));
                    bor.setB(Integer.parseInt(order.get(j+1)));
                    switch (findMode.substring(0, 1)){
                        case "e":
                            ans = bor.exp();
                            break;
                        case "d":
                            ans = bor.div();
                            break;
                        case "a":
                            ans = bor.add();
                            break;

                    }
                    order.set(j+1, Integer.toString(ans));
                    order.remove(j-1); 
                    order.remove(j-1);
                    if (!order.contains(findMode.substring(0, 1)) && !order.contains(findMode.substring(1, findMode.length()))){
                        break;
                    }
                }
                else if (order.get(j).equals(findMode.substring(1, findMode.length()))){
                    bor.setA(Integer.parseInt(order.get(j-1)));
                    bor.setB(Integer.parseInt(order.get(j+1)));
                    switch (findMode.substring(1, findMode.length())){
                        case "m":
                            ans = bor.mul();
                            break;
                        case "s":
                            ans = bor.sub();
                            break;

                    }
                    order.set(j+1, Integer.toString(ans));
                    order.remove(j-1); 
                    order.remove(j-1);
                    if (!order.contains(findMode.substring(0, 1)) && !order.contains(findMode.substring(1, findMode.length()))){
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(order.get(0)); //test return value
    }
}
