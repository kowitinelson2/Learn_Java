package com.miller.learn.basicio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class RandomAccessFiles {
    public static Path file = Paths.get("com/miller/learn/basicio/xanadu.txt");
    public static void openFileReadAndWrite() throws IOException {
        String  s = "I was here!\n";
        byte[] data = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);

        ByteBuffer copy = ByteBuffer.allocate(12);

        try(FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
            // Read the first 12 bytes of the file
            int nread;
            do{
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            //Write I was here at the beginning of the file
            fc.position(0);
            while(out.hasRemaining()) {
                fc.write(out);
                out.rewind();
            }

            // move to the end of the file. Copy the first 12 bytes
            // to the end of the file. Then write "I was here!"

            long length = fc.size();
            fc.position(length - 1);
            copy.flip();
            while(copy.hasRemaining()) {
                fc.write(copy);
            }
            while (out.hasRemaining()) {
                fc.write(out);
            }

        } catch (IOException e) {
            System.out.println("I/O Exception: " + e);
        }
    }


}
