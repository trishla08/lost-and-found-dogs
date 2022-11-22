package com.trishla.aurora.repository;

import java.io.*;
 
class CustomObjectOutputStream extends ObjectOutputStream {
 
    CustomObjectOutputStream() throws IOException
    {
         super();
    }
 
    CustomObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }
 
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}