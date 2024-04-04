package model.document;

import java.util.Date;

public abstract class Document {
      private String docID;
      private String docName;
      private Date creationDate;
      private String filePath;
      
      public Document(String docID, String docName) {
    	  this.docID = docID;
    	  this.docName = docName;
    	  this.creationDate = new Date();
    	  this.filePath = "";
      }
      
      public void updateName(String newName) {
    	  this.docName = newName;
      }
      
      public void updatePath(String newPath) {
    	  this.filePath = newPath;
      }
      
      protected abstract String getType(); // for coverletter and resume
      
      public String getDocID() {
    	  return docID;
      }
      
      public String getDocName() {
    	  return docName;
      }
      
      public Date getCreationDate() {
    	  return creationDate;
      }
      
      public String getFilePath() {
    	  return filePath;
      }
}
