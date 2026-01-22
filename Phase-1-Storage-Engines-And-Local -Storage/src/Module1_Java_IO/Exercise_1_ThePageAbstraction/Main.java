package Module1_Java_IO.Exercise_1_ThePageAbstraction;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            PageManager pm = new PageManager();

            // 1. Create a sample page
            // We use 1023 to respect the 4KB budget (1023 * 4 + 4 = 4096)
            int[] data = new int[1023];
            data[0] = 777;           // Landmark 1: Start
            data[512] = 12345;       // Landmark 2: Middle
            data[1022] = 999;        // Landmark 3: End

            Page originalPage = new Page(14, data);

            // 2. Test Write
            System.out.println("Writing Page ID: " + originalPage.ID);
            pm.writePage(originalPage);

            // 3. Test Read
            System.out.println("Reading Page ID: 14 back from disk...");
            Page fetchedPage = pm.readPage(14);

            // 4. Verification Logic
            if (fetchedPage.ID == originalPage.ID &&
                    fetchedPage.arr[0] == 777 &&
                    fetchedPage.arr[1022] == 999) {
                System.out.println("SUCCESS: The data retrieved matches the data stored!");
            } else {
                System.out.println("FAILURE: Data corruption or mismatch detected.");
            }

        } catch (IOException e) {
            System.err.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}