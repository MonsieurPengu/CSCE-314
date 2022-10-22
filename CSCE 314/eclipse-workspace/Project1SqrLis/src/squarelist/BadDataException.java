// Name: Ian Wang
// Section: CSCE 314 700 - Group 28
// UIN: 227004716
package squarelist;

import java.io.IOException;

class BadDataException extends Exception {
    public BadDataException(String s) {
    	super(s);
    }
    // OOPSIE DAISIES! BAD DATA!
    static void OopsieDaisies() throws IOException {
    	throw new IOException("Data Error in File");
    }
}
