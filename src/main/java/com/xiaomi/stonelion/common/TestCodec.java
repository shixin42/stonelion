package com.xiaomi.stonelion.common;

import com.xiaomi.stonelion.MaxBase;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Created by ishikin on 15-1-9.
 */
public class TestCodec extends MaxBase {

    public static void main(String[] args) throws DecoderException {
    }

    /**
     * Only can decode hex string!
     *
     * @throws DecoderException
     */
    public static void testDecodeHex() throws DecoderException {
        String str = "abcde1";
        byte[] bytes = Hex.decodeHex(str.toCharArray());
        out(bytes.length);
    }

}
