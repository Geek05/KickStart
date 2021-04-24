package org.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class TestBraces {

    /**
     * If there is `(` there should be `)`
     * If there is `[` there should be `]`
     *
     * True
     * abcde(efghij klm)nopqr
     * abcdefg[sdfVsass]kjlWksp
     * qwerty[sdf(kljs)ksdf]lsdf
     * asdfg(kshsgs)kagshs[hdhhdhd]ndfdg
     *
     * False
     * abcde[sdfg[mkk
     * lbcd efgh (kkljUklk[op
     * lbcd efgh (kkljUklk[op(]
     * kkkk[lsllsls{ll]poew}
     *
     * (())
     */
    public Boolean parseBraces(String input){
        char[] charArray = input.toCharArray();
        Stack<Character> roundBraces = new Stack<>();
        Stack<Character> squareBraces = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                roundBraces.push(charArray[i]);
                continue;
            }
            if(charArray[i] == ')') {
                roundBraces.pop();
                continue;
            }

            if(charArray[i] == '[') {
                squareBraces.push(charArray[i]);
                continue;
            }
            if(charArray[i] == ']') {
                squareBraces.pop();
                continue;
            }
        }
        return (roundBraces.size() == 0 && squareBraces.size() == 0);
    }

    @Test
    public void testBraces() {
        Assert.assertTrue(parseBraces("abcde(efghij klm)nopqr"));
        Assert.assertTrue(parseBraces("abcdefg[sdfVsass]kjlWksp"));
        Assert.assertTrue(parseBraces("qwerty[sdf(kljs)ksdf]lsdf"));
        Assert.assertTrue(parseBraces("asdfg(kshsgs)kagshs[hdhhdhd]ndfdg"));

        Assert.assertFalse(parseBraces("abcde[sdfg[mkk"));
        Assert.assertFalse(parseBraces("lbcd efgh (kkljUklk[op"));
        Assert.assertFalse(parseBraces("lbcd efgh (kkljUklk[op(]"));
        Assert.assertTrue(parseBraces("kkkk[lsllsls{ll]poew}"));
    }
}
