
package model.document;

public class CoverLetter extends Document {
     public CoverLetter(String docID, String docName) {
    	 super(docID, docName);
     }
     
     @Override
     protected String getType() {
    	 return "Cover Letter";   //what should we return
     }
}
