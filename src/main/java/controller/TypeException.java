package controller;

/***
 * Exception for when invalid input is given to the node creator in the controller.
 */
public class TypeException  extends Exception {
    private String s;

    public TypeException(String s) {
        this.s = "Invalid input for this type: " + s;
    }

    public String getMsg() {
        return this.s;
    }
}
