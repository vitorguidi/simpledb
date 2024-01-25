package com.vguidi.simpledb.filemanager;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BlockId {
    private final String filename;
    private final int blkNum;

    public BlockId(String filename, int blkNum) {
        this.filename = filename;
        this.blkNum = blkNum;
    }
    public int number() {
        return blkNum;
    }

    public String filename() {
        return filename;
    }
}
