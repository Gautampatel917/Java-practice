/*Access modify in java
There are four types in java
1.Default 2.private 3.protected 4.public
Default :  In Default there are no need to any keyword to specify or initialize property
           There only accessible with same Package

Types of inheritance : single , multiple , hierarchical, hybrid
Hierarchical : One parents class and multiple child class
Hybrid: Combination of multiple types of inheritance
 */

public class G_3_inheritance {

    public class Base{
        public int x = 10;
        public int getX(){
            return x;
        }
    }

    public class Derive extends  Base{
        public void print_msg(){
            System.out.println("Message from Derive class");
        }
    }

    public static void main(String[] args) {
        Derive d = new Derive();
        System.out.print(d.getX());
    }
}
