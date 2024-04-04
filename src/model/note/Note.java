package model.note;

import java.util.Date;

public class Note {
       private String noteID;
       private String content;
       private Date createDate;
       private Date updateDate;
       
       public Note(String noteID, String content) {
    	   this.noteID = noteID;  // generate by method or create by user
    	   this.content = content;
    	   this.createDate = new Date();
    	   this.updateDate = new Date();
       }
       
       public String getNoteID() {
    	   return noteID;
       }
       
       public String getContent() {
    	   return content;
       }
       
       public void updateContent(String newContent) {
    	   content = newContent;
    	   updateDate = new Date();
       }
}
