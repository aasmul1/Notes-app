package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.Accounts;
import json.internal.AccountsModule;

public class AccountsPersistence {

  private final ObjectMapper mapper;
  private Path filePath;

  public AccountsPersistence() {
    mapper = new ObjectMapper().registerModule(new AccountsModule());
  }

  public static ObjectMapper getObjectMapper() {
    return new ObjectMapper().registerModule(new AccountsModule());
  }

  /**
   * Sets file path for storage (on user.home)
   * 
   * @param saveFile is the name of the file
   */
  public void setFilePath(String saveFile) {
    this.filePath = Paths.get(System.getProperty("user.home"), saveFile);
  }

  /**
   * 
   * @return filepath
   */
  public Path getSaveFilePath() {
    return this.filePath;
  }

  /**
   * Method for getting locally saved account data.
   * 
   * @return the accounts that are saved
   * @throws StreamReadException
   * @throws DatabindException
   * @throws IOException
   */
  public Accounts loadAccounts() throws StreamReadException, DatabindException, IOException {
    if (filePath == null) {
      throw new IllegalArgumentException("file path not set");
    }
    Reader reader = new FileReader(filePath.toFile(), StandardCharsets.UTF_8);
    return mapper.readValue(reader, Accounts.class);
  }

  /**
   * Saves accounts to the file
   * 
   * @param accounts
   * @throws StreamWriteException
   * @throws DatabindException
   * @throws IOException
   */
  public void saveAccounts(Accounts accounts)
      throws StreamWriteException, DatabindException, IOException {
    if (filePath == null) {
      throw new IllegalStateException("file path is not set");
    }
    Writer writer = new FileWriter(filePath.toFile(), StandardCharsets.UTF_8);
    mapper.writeValue(writer, accounts);

  }
}
