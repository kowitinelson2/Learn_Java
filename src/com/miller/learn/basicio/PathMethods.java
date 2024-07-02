package com.miller.learn.basicio;

import java.nio.file.*;

public class PathMethods {

    Path path;
    public PathMethods() {
        path = Paths.get("C:\\Users\\nkowiti\\testing.txt");
    }

    public void testPathMethods() {
        System.out.format("toString: %s%n", path.toString() ); // C:\Users\nkowiti\testing.txt
        System.out.format("getFileName: %s%n", path.getFileName()); // testing.txt
        System.out.format("getName(0): %s%n", path.getName(0)); // Users
        System.out.format("getNameCount: %d%n", path.getNameCount()); // 3
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2)); // Users\nkowiti
        System.out.format("getParent: %s%n", path.getParent()); // C:\Users\nkowiti
        System.out.format("getRoot: %s%n", path.getRoot()); // C:\
    }
}
