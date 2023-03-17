package HomeworkTask1;

public class InvalidEmail extends IllegalArgumentException {

  public InvalidEmail(String mistake) {
    super("Incorrect input email: " + mistake);
  }
}
