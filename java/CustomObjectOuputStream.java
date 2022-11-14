import java.io.*;
// Importing utility classes
import java.util.*;
 
// Class 1
// helper class
class CustomObjectOutputStream extends ObjectOutputStream {
 
    // Constructor of this class
    // 1. Default
    CustomObjectOutputStream() throws IOException
    {
 
        // Super keyword refers to parent class instance
        super();
    }
 
    // Constructor of this class
    // 1. Parameterized constructor
    CustomObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }
 
    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}