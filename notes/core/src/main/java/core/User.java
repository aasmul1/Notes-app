package core;

public class User {
    private String username;
    private String password;
    private NoteOverview noteOverview;

    /**
     * Constructor that is used to create a instance of this class.
     * 
     * @param username users username
     * @param password users password
     * @param noteOverview the users note overview
     */
    
    public User(String username, String password, NoteOverview noteOverview) {
        UserValidation.checkValidUsername(username);
        UserValidation.checkValidPassword(password);

        this.username = username;
        this.password = password;
        this.noteOverview = noteOverview;
    }

    /**
     * Access method for username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set method for new username.
     * 
     * @param username users username
     */
    public void setUsername(String username) {
        UserValidation.checkValidUsername(username);
        this.username = username;
    }

    /**
     * Access method for users password
     * 
     * @return users password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set method for new password
     * 
     * @param password users password
     */
    public void setPassword(String password) {
        UserValidation.checkValidPassword(password);
        this.password = password;
    }

    /**
     * Access method for users notes
     * 
     * @return a copy of users noteoverview-list
     */
    public NoteOverview getNoteOverview() {
        return this.noteOverview;
    }

    /**
     * Access method for a specified note
     * 
     * @param note to be accessed
     * @return the note 
     */
    public Note getNote(Note note) {
        return getNoteOverview().getNotes().stream().filter(n -> n.getTitle().equals(note.getTitle()))
                                 .findAny()
                                 .orElse(null); 
    }

    /**
     * Adds note to users noteoverview
     * 
     * @param note to be added 
     */
    public void addNote(Note note) {
        if(!noteExists(note)) {
            noteOverview.addNote(note);
        }
    }

    /**
     * Checks if the note exists in noteoverview
     * 
     * @param note the note to check
     * @return boolean
     */
    public boolean noteExists(Note note) {
        for (Note n : noteOverview.getNotes()) {
            if(note.getTitle().equals(n.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public Note getNoteByIndex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException(Errors.SELECT_NOTE.getMessage());
        }
        if (index > noteOverview.getNotes().size() - 1) {
            throw new IllegalArgumentException(Errors.INVALID_INDEX.getMessage());
        }
        return noteOverview.getNotes().get(index);
    }

}
