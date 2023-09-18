package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import core.Note;
import core.NoteOverview;

public class NoteSerializer extends JsonSerializer<Note> {
    public static final String TITLE_FIELD_NAME = "title";
    public static final String TEXT_FIELD_NAME = "text";

    @Override
    public void serialize(Note note, JsonGenerator jsonGen, SerializerProvider provider) throws IOException {
        jsonGen.writeStartObject();
        jsonGen.writeFieldName(TITLE_FIELD_NAME);
        jsonGen.writeObjectField(TITLE_FIELD_NAME, note.getTitle());
        jsonGen.writeFieldName(TEXT_FIELD_NAME);
        jsonGen.writeObjectField(TEXT_FIELD_NAME, note.getText());
        jsonGen.writeEndObject();
    }
   

}
