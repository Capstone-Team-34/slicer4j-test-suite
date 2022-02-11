package JtopasTest;

import jtopas.*;

// This will print the contents of a HTML file as a
// roughly formatted text

// Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import jtopas.Token;
import jtopas.Tokenizer;
import jtopas.TokenizerProperties;
import jtopas.StandardTokenizer;
import jtopas.StandardTokenizerProperties;
import jtopas.ReaderSource;

// class to hold main method
public class Test {

    // get a file from the resources folder
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public static void main(String[] args) {
        Test app = new Test();

        //String fileName = "database.properties";
        String fileName = "html/test.html";

        System.out.println("getResourceAsStream : " + fileName);
        InputStream stream = app.getFileFromResourceAsStream(fileName);

        InputStreamReader reader = new InputStreamReader(stream);
        TokenizerProperties props = new StandardTokenizerProperties();
        Tokenizer tokenizer = new StandardTokenizer();
        Token token;
        int len;

        // setup the tokenizer
        props.setParseFlags(TokenizerProperties.F_NO_CASE
                                    | TokenizerProperties.F_TOKEN_POS_ONLY
                                    | TokenizerProperties.F_RETURN_WHITESPACES);
        props.setSeparators(null);
        props.addBlockComment("<", ">");
        props.addBlockComment("<HEAD>", "</HEAD>");
        props.addBlockComment("<!--", "-->");
        props.addSpecialSequence("&lt;", "<");
        props.addSpecialSequence("&gt;", ">");
        props.addSpecialSequence("<b>", "");
        props.addSpecialSequence("</b>", "");
        props.addSpecialSequence("<i>", "");
        props.addSpecialSequence("</i>", "");
        props.addSpecialSequence("<code>", "");
        props.addSpecialSequence("</code>", "");

        tokenizer.setTokenizerProperties(props);
        tokenizer.setSource(new ReaderSource(reader));

        // tokenize the file and print basically
        // formatted context to stdout
        len = 0;
        while (tokenizer.hasMoreToken()) {
            try {
                token = tokenizer.nextToken();
            } catch (TokenizerException e) {
                e.printStackTrace();
                break;
            }
            switch (token.getType()) {
                case Token.NORMAL:
                    System.out.print(tokenizer.currentImage());
                    len += token.getLength();
                    break;
                case Token.SPECIAL_SEQUENCE:
                    System.out.print((String) token.getCompanion());
                    break;
                case Token.BLOCK_COMMENT:
                    if (len > 0) {
                        System.out.println();
                        len = 0;
                    }
                    break;
                case Token.WHITESPACE:
                    if (len > 75) {
                        System.out.println();
                        len = 0;
                    } else if (len > 0) {
                        System.out.print(' ');
                        len++;
                    }
                    break;
            }
        }
    }
}

