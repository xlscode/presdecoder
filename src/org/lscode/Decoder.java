package org.lscode;

import java.util.Arrays;
import java.util.List;

public class Decoder {
    private List<Character> forbidden = Arrays.asList('\'', '"', '`', '\\', '/', '@' );

    public String decode(String message){
        StringBuffer result = new StringBuffer();
        int len = message.length();
        boolean subst = false;
        char ch0;
        char ch1;
        int skipped = 0;
        for ( int i=0; i<len; i++) {
            ch0 = message.charAt(i);
            if (subst){
                subst = false;
                int idx = (int)ch0 - (int)'A';
                result.append(decodeChar(forbidden.get(idx), i - skipped));
            }
            else {
                if (ch0 == '@') {
                    skipped++;
                    subst = true;
                } else {

                    result.append(decodeChar(ch0, i - skipped));
                }
            }
        }
        return result.toString();
    }

    private char decodeChar(char ch, int pos){
        int chval = (int)ch - (pos+1);
        //- (pos % 126) - 1;
        if (chval< 32){chval += (126-32);}
        return (char)chval;
    }
}
