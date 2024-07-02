package com.miller.learn.basicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ChkFileDirMethods {
    public static Path file = Paths.get("com/miller/learn/basicio/xanadu.txt");
    public static Path file2 = Paths.get("output.txt");

    // Checking a file or directory
    public static void checkFileAccessibilityAndExistence() {
        boolean isRegularExecutableFile =  Files.isRegularFile(file) &
                Files.isReadable(file) & Files.isExecutable(file);
        System.out.println(isRegularExecutableFile);
    }

    //Deleting a file or directory
    public static void deleteFileOrDirectory() throws IOException {
        try {
            Files.delete(file);
        } catch (NoSuchFileException e) {
            System.err.format("%s: no such" + " file or directory%n", file);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", file);
        }

        Files.deleteIfExists(file); // if the file does not exist, no exception is thrown
    }

    // Copying a file or a directory
    public static void copyFileOrDirectory() throws IOException{
        Path path = Files.copy(file, file2, REPLACE_EXISTING);
    }

    //Moving a file or directory
    public static void  moveFileOrDirectory() throws IOException{
        Path path  = Files.move(file, file2, ATOMIC_MOVE);
    }

    // Managing metadata
    public static void basicFileAttributes() throws IOException{
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());
    }

    public static void setTimeStamps() throws IOException {
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        long currentTime = System.currentTimeMillis();
        FileTime ft = FileTime.fromMillis(currentTime);
        Files.setLastModifiedTime(file, ft);
    }

    public static byte[] readByteOrLines() throws IOException {
        // readAllBytes(Path)   readAllLines(Path, Charset)
        return Files.readAllBytes(file);
    }

    public static void readUsingBufferedStream() throws IOException{
        Charset ch = StandardCharsets.US_ASCII;
        try(BufferedReader reader = Files.newBufferedReader(file, ch)) {
            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void writeUsingBufferedStream() throws IOException{
        Charset ch = StandardCharsets.US_ASCII;
        String s = "Quick brown fox";
        try(BufferedWriter writer = Files.newBufferedWriter(file, ch)) {
            writer.write(s, 0, s.length());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void readUsingChannel() throws IOException {
        // Files.newByteChannel() defaults to StandardOpenOption.READ
        try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
            final int BUFFER_CAPACITY = 10;
            ByteBuffer buf = ByteBuffer.allocate(BUFFER_CAPACITY);

            // Read the bytes with the proper encoding for this platform. If
            // you skip this step, you might see foreign or illegible
            // characters.
            String encoding = Charset.defaultCharset().displayName();
            while (sbc.read(buf) > 0) {
                buf.flip();
                System.out.print(Charset.forName(encoding).decode(buf));
                buf.clear();
            }
        }
    }

    public static void createFile() {
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s" +
                    " already exists%n", file);
        } catch (IOException x) {
            // Some other sort of failure, such as permissions.
            System.err.format("createFile error: %s%n", x);
        }
    }


}
