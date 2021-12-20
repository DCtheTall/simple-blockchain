// Implementation of a simple blockchain.

import java.util.ArrayList;

public class Blockchain {
    private static ArrayList<Block> blockchain_ = new ArrayList<Block>();

    private static String hashOfHead() {
        if (blockchain_.size() == 0) {
            return "0";
        }
        return blockchain_.get(blockchain_.size() - 1).hash();
    }

    private static void addBlock(String data) {
        blockchain_.add(new Block(data, hashOfHead()));
    }

    private static Boolean isValid() {
        Block cur;
        Block prev;
        for (int i = 1; i < blockchain_.size(); ++i) {
            cur = blockchain_.get(i);
            prev = blockchain_.get(i - 1);
            if (!cur.validate(prev)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            addBlock("Block 1");
            if (!isValid()) {
                throw new RuntimeException("Invalid after first block");
            }

            addBlock("Block 2");
            if (!isValid()) {
                throw new RuntimeException("Invalid after second block");
            }

            // Modify a blockchain mode's data and the following code will throw
            // an exception.
            // blockchain_.get(0).setData("Invalid");

            addBlock("Block 3");
            if (!isValid()) {
                throw new RuntimeException("Invalid after third block");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
