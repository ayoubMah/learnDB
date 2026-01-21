package Module1_Java_IO.Exercise_1_ThePageAbstraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class PageManager {

    final int PAGE_SIZE = 4096; // 4KB

    RandomAccessFile file = new RandomAccessFile("database.db", "rw");

    public PageManager() throws FileNotFoundException {}

    public void writePage(Page page) throws IOException {
        long offset = page.ID;
        offset += page.ID * PAGE_SIZE;
        // step1: create a buffer of the page size
        ByteBuffer buffer = ByteBuffer.allocate(PAGE_SIZE);
        // step2: put the data in
        buffer.putInt(page.ID);
        for (int val : page.arr){
            buffer.putInt(val); // pack the integers one by one
            file.seek(offset);
            file.write(val);
        }
        buffer.array();
    }

    public void readPage(int pageId){
    }
}
