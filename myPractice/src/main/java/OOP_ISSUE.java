public class OOP_ISSUE {

    public static void main (String[] args) {

        Parent p =new Child("child");
        p.printValue();


    }
}

class Parent {
    Parent() {
        // Dangerous! This method can be overridden by a subclass.
//        printValue();
    }

    void printValue() {
        System.out.println("Parent default");
    }
}

class Child extends Parent {
    private String message;

    Child(String message) {
        this.message = message; // This assignment happens TOO LATE
    }

    @Override
    void printValue() {
        // Triggers a NullPointerException because 'message' is still null!
        System.out.println(message.toUpperCase());
    }
}
