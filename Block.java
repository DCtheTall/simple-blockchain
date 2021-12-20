// Java implementation of a blockchain node.

import java.util.Date;

public class Block {
    private String previousHash_;
    private String data_;
    private long timestamp_;
    private String hash_;

    public Block(String data, String previousHash) {
        data_ = data;
        previousHash_ = previousHash;
        timestamp_ = new Date().getTime();
        hash_ = computeHash();
    }

    public String hash() { return hash_; }

    // Used to demonstrate blockchain's resistance to tampering.
    public void setData(String data) {
        data_ = data;
    }

    private String computeHash() {
        return Crypto.sha256(previousHash_ + Long.toString(timestamp_) + data_);
    }

    public Boolean validate(Block prev) {
        return validateHash() && prev.validateHash() && prev.hash_.equals(previousHash_);
    }

    private boolean validateHash() {
        return hash_.equals(computeHash());
    }

    public static void main(String[] args) {
        Block block = new Block("", "");
        System.out.println(block.hash_);
    }
}