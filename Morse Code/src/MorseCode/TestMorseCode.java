package MorseCode;

public class TestMorseCode {
	public static void main(String[] args) {
        //Do not modify this file.
        MorseCoder mc = new MorseCoder();
         
            mc.inOrderPrint();
            System.out.println();
            mc.print(mc.getLetter(), 0);
            
            // sos decode
            System.out.println("Decode Test 1");
            String str = "... --- ..."; 
            System.out.println("str = " + str);
            System.out.println("str should decode to: sos");
            System.out.println("decode(str) = " + mc.decode(str));
            testResults("sos", mc.decode(str));
         
            // abcdef...xyz decode
            System.out.println("Decode Test 2");
            str = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -."
                + " --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
            System.out.println("str = " + str);
            System.out.println("str should decode to: abcdefghijklmnopqrstuvwxyz");
            System.out.println("decode(str) = " + mc.decode(str));
            testResults("abcdefghijklmnopqrstuvwxyz", mc.decode(str));
          
            // helpmeobiwanyouremyonlyhope decode
            System.out.println("Decode Test 3");
            str = ".... . .-.. .--. -- . --- -... .. .-- .- -. -.-- --- ..-"
                + " .-. . -- -.-- --- -. .-.. -.-- .... --- .--. .";
            System.out.println("str = " + str);
            System.out.println("str should decode to: helpmeobiwanyouremyonlyhope");
            System.out.println("decode(str) = " + mc.decode(str));
            testResults("helpmeobiwanyouremyonlyhope", mc.decode(str));
         
            // --.. encode
            System.out.println("Encode Test 1");
            str = "z";
            System.out.println("str = " + str);
            System.out.println("str should encode to: --..");
            System.out.println("encode(str) = "+ mc.encode(str));
            testResults("--..", mc.encode(str));
         
            // ... --- ... encode
            System.out.println("Encode Test 2");
            str = "sos";
            System.out.println("str = " + str);
            System.out.println("str should encode to: ... --- ...");
            System.out.println("encode(str) = " + mc.encode(str));
            testResults("... --- ...", mc.encode(str));
         
            // .-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -. encode
            System.out.println("Encode Test 3");
            str = "runforrestrun";
            System.out.println("str = " + str);
            System.out.println("str should encode to: .-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -.");
            System.out.println("encode(str) = " + mc.encode(str));
            testResults(".-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -.", mc.encode(str));
            
            
            
    }
     
    /**
     * Tests if the output string matches the expected.
     * Prints "Test: Passed" if they match, otherwise prints "Test: Failed"
     * @param one String - Expected output
     * @param two String - Encoded/Decoded call
     */
    public static void testResults(String one, String two) {
        if(one.trim().equals(two.trim()))
            System.out.println("Test: Passed");
        else
            System.out.println("Test: Failed");
        System.out.println();
    }

}
