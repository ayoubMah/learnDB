import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String address;
    private Date doffe; // date of first enrollment
    private int nochc; // number of credit hours completed

    public Student(int id, String name, String address, Date doffe, int nochc){
        this.id = id;
        this.name = name;
        this.address = address;
        this.doffe = doffe;
        this.nochc = nochc;
    }
    // getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDoffe() {
        return doffe;
    }
    public void setDoffe(Date doffe) {
        this.doffe = doffe;
    }
    public int getNochc() {
        return nochc;
    }
    public void setNochc(int nochc) {
        this.nochc = nochc;
    }

    // increment
    public void increment (int incBy){
        nochc+= incBy;
    }


}
