package model.document;

import java.util.ArrayList;
import java.util.List;

public class DocumentList {
      private List<Document> documents;
      
      public DocumentList() {
    	  this.documents = new ArrayList<>();
      }
      
//      public void addDoc(String docID, DOCTYPE type, String docName) {
//    	  Document document;
//    	  switch(type) {
//    	     case CoverLetter:    // how many types should we have ,just 2 or it can be added by users
//    	    	 document = new CoverLetter(docID,docName);
//    	    	 break;
//    	     case Resume:
//    	    	 document = new Resume(docID,docName);
//    	    	 break;
//    	    	// add more cases....
//    	     default:
//    	    	 throw new IllegalArgumentException("Unsupported document type.")
//    	  }
//    	  documents.add(document);
//      }
      
      public void removeDoc(String docID) {
    	  documents.removeIf(doc -> doc.getDocID().equals(docID));
      }
      
      public Document findDoc(String docID){
    	  for(Document doc: documents) {
    		  if(doc.getDocID().equals(docID)) {
    			  return doc;
    		  }
    	  }
    	  return null;
      }
}
