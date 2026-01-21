### Exercise 1: The "Page" Abstraction

**Objective:** Create a simple Java class that can write a "Page" of data to a specific offset in a file and read it back.

**Requirements:**
1.  Create a class `Page` that holds an ID (int) and a fixed-size byte array (e.g., 4KB).
2.  Create a `PageManager` class.
    *   `writePage(Page page)`: Writes the page to disk at `offset = pageID * 4096`.
    *   `readPage(int pageId)`: Seeks to the offset and reads the page.
3.  **Constraint:** Use `RandomAccessFile` and `ByteBuffer`. Do not use `Serializable`.

**Resources:**
*   [Java RandomAccessFile Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/RandomAccessFile.html)
*   [Java ByteBuffer Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/ByteBuffer.html)