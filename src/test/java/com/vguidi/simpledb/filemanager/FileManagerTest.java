package com.vguidi.simpledb.filemanager;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    private final String DB_FILE_NAME = "filetest";
    private final String TEST_FILE_NAME = "testfile";
    private final String TEST_FILE_CONTENT = "abcdefghijklm";

    @Test
    public void TestFileManager() {
        File dbFile = new File(DB_FILE_NAME);
        FileManager mgr = new FileManager(dbFile, 400);
        System.out.println("Current dir:" + dbFile.getAbsoluteFile());


        BlockId blk = new BlockId(TEST_FILE_NAME, 2);
        Page p1 = new Page(mgr.blockSize());
        int pos1 = 88;
        p1.setString(pos1, TEST_FILE_CONTENT);
        int size = Page.maxLength(TEST_FILE_CONTENT.length());
        int pos2 = pos1 + size;
        p1.setInt(pos2, 345);
        mgr.write(blk, p1);

        Page p2 = new Page(mgr.blockSize());
        mgr.read(blk, p2);
        System.out.println("offset " + pos2 + " contains " +  p2.getInt(pos2));
        System.out.println("offset " + pos1 + " contains " + p2.getString(pos1));
    }

}