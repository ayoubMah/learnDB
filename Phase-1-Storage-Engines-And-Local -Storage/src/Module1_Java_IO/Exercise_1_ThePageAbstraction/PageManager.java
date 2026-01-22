package Module1_Java_IO.Exercise_1_ThePageAbstraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class PageManager {

    final int PAGE_SIZE = 4096; // 4KB

    RandomAccessFile file = new RandomAccessFile("database.db", "rw");

    public PageManager() throws FileNotFoundException {}

    // RAM to disk
    // serialization 
    public void writePage(Page page) throws IOException {
        long offset = (long)page.ID * PAGE_SIZE;

        // step1: create a buffer of the page size
        ByteBuffer buffer = ByteBuffer.allocate(PAGE_SIZE);
        // step2: put the data in
        buffer.putInt(page.ID);
        for (int val : page.arr){
            buffer.putInt(val); // pack the integers one by one
        }
        file.seek(offset);
        file.write(buffer.array());
    }
    
    // disk to RAM
    // deserialization 
    public Page readPage(int pageId) throws IOException {
        long offset = (long)pageId * PAGE_SIZE;
        file.seek(offset);
        
        // the physical container 
        byte[] arr = new byte[PAGE_SIZE];
        file.read(arr);
        
        ByteBuffer buffer = ByteBuffer.wrap(arr);// don't allocate a new memory, use this existing one as source

        // get the header : id
        int ID = buffer.getInt();

        int[] pageArr = new int[1023]; // 1023 to leave room for the id header
        for (int i = 0; i < pageArr.length; i++){
            pageArr[i] = buffer.getInt();
        }

        Page page = new Page(ID, pageArr);
        return page;
        
    }
}
