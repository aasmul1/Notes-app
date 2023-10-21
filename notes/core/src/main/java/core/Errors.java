package core;

public enum Errors {
  USERNAME_FIELD_EMPTY("Please enter an username."),
  PWD_FIELD_EMPTY("Please enter a password."),
  EVERYTHING_EMPTY("All fields must be filled out."),
  INVALID_USERNAME("Name should only contain letters, and be atleast five letters.."),
  INVALID_PWD("Invalid password, must be at least 8 characters"
    + " and contain at least 1 digit and 1 lower and uppercase letter."),
  INVALID_USERNAME_AND_OR_PWD("Invalid username address or password."),
  NOT_REGISTERED("This user is not registered."),
  NOT_EQUAL_PASSWORD("Passwords does not match."),
  NOT_EQUAL_USERNAME("Username do not match");

  private final String errorMessage;

  Errors(final String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getMessage() {
    return errorMessage;
  }
}
