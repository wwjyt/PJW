package shop;

public class Customer {
    private int C_id;
    private String name;

    public Customer() {
    }

    public Customer(int C_id, String name){
        this.C_id = C_id;
        this.name = name;
    }

    public int getC_id(){
        return C_id;
    }

    public void setC_id(int C_id){
        this.C_id = C_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
