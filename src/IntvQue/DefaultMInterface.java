package IntvQue;

//https://www.digitalocean.com/community/tutorials/java-8-interface-changes-static-method-default-method
interface FirstInterface{
    default void log(){
        System.out.println("From FirstInterface");
    }
    static void print(){
        System.out.println("From FirstInterface print");
    }
}

@FunctionalInterface
interface SecondInterface{
    void log();
}

public class DefaultMInterface implements FirstInterface, SecondInterface{
    public static void main(String[] args){
        DefaultMInterface m = new DefaultMInterface();
        m.log();
        m.print();
    }

    @Override
    public void log() {
        System.out.println("From Class");
        FirstInterface.super.log();
    }

    public void print(){
        System.out.println("From Class print");
        FirstInterface.print();
    }
}
