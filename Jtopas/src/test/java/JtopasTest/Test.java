package JtopasTest;

import jtopas.*;

// This will print the contents of a HTML file as a
// roughly formatted text

// Imports
import jtopas.Token;
import jtopas.Tokenizer;
import jtopas.StandardTokenizer;
import jtopas.StandardTokenizerProperties;
import jtopas.ReaderSource;

// class to hold main method
public class Test {
//
//    // Main method. Supply a HTML file name as argument
//    public static void main(String[] args) {
//        try {
//            // setup the tokenizer properties
//            TokenizerProperties props     = new StandardTokenizerProperties();
//            props.setSeparators(null);
//            props.addBlockComment("<", ">");
//            props.addBlockComment("<HEAD>", "</HEAD>");
//            props.addBlockComment("<!--", "-->");
//            props.addSpecialSequence("&lt;", "<");
//            props.addSpecialSequence("&gt;", ">");
//            props.addSpecialSequence("<b>", "");
//            props.addSpecialSequence("</b>", "");
//            props.addSpecialSequence("<i>", "");
//            props.addSpecialSequence("</i>", "");
//            props.addSpecialSequence("<code>", "");
//            props.addSpecialSequence("</code>", "");
//
//            // Case-sensitive HTML elements
//            props.addSpecialSequence("&auml;", "ä", 0, 248);
//            props.addSpecialSequence("&Auml;", "Ä", 0, 248);
//            props.addSpecialSequence("&ouml;", "ö", 0, Flags.F_NO_CASE);
//            props.addSpecialSequence("&Ouml;", "Ö", 0, Flags.F_NO_CASE);
//            props.addSpecialSequence("&uuml;", "ü", 0, Flags.F_NO_CASE);
//            props.addSpecialSequence("&Uuml;", "Ü", 0, Flags.F_NO_CASE);
//            props.addSpecialSequence("&szlig;", "ß");
//
//            // create the tokenizer
//            Tokenizer           tokenizer = new StandardTokenizer(props);
//            TokenizerSource     source    = new ReaderSource(args[0]);
//            Token               token;
//            int                 len;
//
//            try {
//                tokenizer.setSource(new ReaderSource(args[0]));
//
//                // tokenize the file and print basically
//                // formatted context to stdout
//                len = 0;
//                while (tokenizer.hasMoreToken()) {
//                    token = tokenizer.nextToken();
//                    switch (token.getType()) {
//                        case Token.NORMAL:
//                            System.out.print(tokenizer.current());
//                            len += token.getLength();
//                            break;
//                        case Token.SPECIAL_SEQUENCE:
//                            System.out.print((String)token.getCompanion());
//                            break;
//                        case Token.BLOCK_COMMENT:
//                            if (len > 0) {
//                                System.out.println();
//                                len = 0;
//                            }
//                            break;
//                        case Token.WHITESPACE:
//                            if (len > 75) {
//                                System.out.println();
//                                len = 0;
//                            } else if (len > 0) {
//                                System.out.print(' ');
//                                len++;
//                            }
//                            break;
//                    }
//                } finally {
//                    // never forget to release resources and references
//                    tokenizer.close();
//                    source.close();
//                }
//            }
//        } catch (Throwable throwable) {
//            // catch and print all exceptions and errors
//            throwable.printStackTrace();
//        }
//    } // end of main
} // end of class

