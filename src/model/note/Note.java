package model.note;

import java.time.*;  // this will import all classes in java.time package


import model.utilities.BaseId;

public class Note extends BaseId{
	
	   final String prefix = "note-";
	   private static int nextId = 1;
       private String noteId;
       
       private String title;
       private String content;
       private LocalDate createDate;
       private LocalDate updateDate;
       
       // note id format: note-1, note-2, etc.
       protected void generateId(String prefix) {
    	   this.noteId = prefix + nextId;
       }
       
       public Note(String title, String content) {
    	   generateId(prefix);
    	   this.title = title;
    	   this.content = content;
    	   this.createDate = LocalDate.now();
    	   this.updateDate = LocalDate.now();
       }
       
       public String getNoteId() {
    	   return this.noteId;
       }
       
       public String getTitle() {
    	   return this.title;
       }
       
       public String getContent() {
    	   return this.content;
       }
       
       public void updateContent(String newContent) {
    	   this.content = newContent;
    	   this.updateDate = LocalDate.now();
       }
       
       public void updateTitle(String newTitle) {
    	   this.title = newTitle;
    	   this.updateDate = LocalDate.now();
}
