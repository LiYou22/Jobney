package model.note;

import java.util.List;

public class NoteList {
      private List<Note> noteList;
      
      public NoteList() {
    	  this.noteList = new ArrayList<>();
      }
      
      public List<Note> getNoteList(){
          return noteList;
      }
      
      public void addNote(String content) {
    	  Note note = new Note(content);
    	  noteList.add(note);
      }
      
      public void updateNote(String noteID, String newContent) {
    	  Note note = findNoteByID(noteID){
    		  if(note != null) {
    			  note.updateContent(newContent);
    		  }
    	  }
      }
}
