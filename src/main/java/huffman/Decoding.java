package huffman;

import org.jetbrains.annotations.NotNull;

class Decoding {

    /*
        class Node
            public  int frequency; // the frequency of this tree
            public  char data;
            public  Node left, right;

    */
    private static String _decode(@NotNull String sequence, @NotNull Node node, @NotNull StringBuilder builder) {
        if (node.right == null && node.left == null) {
            builder.append(node.data);
            return sequence;
        }
        if (sequence.startsWith("1")) {
            return _decode(sequence.substring(1), node.right, builder);
        } else {
            return _decode(sequence.substring(1), node.left, builder);
        }
    }

    static String decode(String sequence, Node root) {
        var builder = new StringBuilder();
        var seq = sequence;
        do {
            seq = _decode(seq, root, builder);
        } while (seq.length() > 0);
        return builder.toString();
    }
}
