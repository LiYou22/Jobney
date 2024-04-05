package model.document;

import java.util.Date;

public abstract class Document {
	
	  private final String prefix = "doc-";
	  private static int nextId = 1;
      private String docId;
      
      private String docName;
      private Date creationDate;
      private String filePath;
      
      public Document(String docName) {
    	  this.docId = prefix + nextId;
    	  this.docName = docName;
    	  this.creationDate = new Date();
    	  this.filePath = "";
    	  nextId++;
      }
      
      public void updateName(String newName) {
    	  this.docName = newName;
      }
      
      public void updatePath(String newPath) {
    	  this.filePath = newPath;
      }
      
      protected abstract String getType(); // for coverletter and resume
      
      public String getDocId() {
    	  return docId;
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
