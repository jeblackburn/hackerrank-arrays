package huffman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodingTest {
    @Test
    void shouldReturnValueForOneLeaf() {
        var leaf = new HuffmanLeaf(1,'a');
        var sequence = "1";
        var result = Decoding.decode(sequence, leaf);
        assertEquals("a", result);
    }

    @Test
    void shouldReturnValueForOneChildOfRoot() {
        var zero = new HuffmanLeaf(1,'z');
        var one = new HuffmanLeaf(1,'a');
        var root = new HuffmanNode(one, zero);
        assertEquals("z", Decoding.decode("1", root));
        assertEquals("a", Decoding.decode("0", root));
    }

    @Test
    void shouldTraverseLeftAndRightFromRoot() {
        var zero = new HuffmanLeaf(1,'z');
        var one = new HuffmanLeaf(1,'a');
        var root = new HuffmanNode(zero, one);
        assertEquals("az", Decoding.decode("10", root));
    }

    @Test
    void shouldTraverseManyLevelsAndReturnToRoot() {
        var rightLeft = new HuffmanLeaf(1,'z');
        var rightRight = new HuffmanLeaf(1,'a');
        var right = new HuffmanNode(rightLeft, rightRight);
        var left = new HuffmanLeaf(1, 'b');
        var root = new HuffmanNode(left, right);
        var sequence = "1100";
        assertEquals("abb", Decoding.decode(sequence, root));


    }
}