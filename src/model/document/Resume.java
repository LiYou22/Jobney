package model.document;

public class Resume extends Document {
	public Resume(String docID, String docName) {
   	 super(docID, docName);
    }
    
    @Override
    protected String getType() {
   	 return "Resume";   //what should we return
    }
}
