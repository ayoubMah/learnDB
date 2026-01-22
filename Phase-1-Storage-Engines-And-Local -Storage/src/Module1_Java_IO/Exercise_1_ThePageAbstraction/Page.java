package Module1_Java_IO.Exercise_1_ThePageAbstraction;

public class Page {
    int ID;
    int[] arr = new int[1023]; // 1KB
    
    public Page(int ID, int[] arr){
        this.ID = ID;
        this.arr = arr;
    }
}
