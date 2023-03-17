//Задача 1
//    Допишите программу из классной работы
//    (см. файлы HomeworkTask1.Account.java и HomeworkTask1.MainAccounts.java).
//
//    Необходимо создать собственное исключение InvalidEmail.
//
//    При попытке создать HomeworkTask1.Account нужно выбрасывать собственное исключение,
//    если в переданном адресе электронной почты нет символа '@'.

package HomeworkTask1;

public class Account {

  final static char AT = '@';
  private final String name;
  private final String email;
  private int reputation;

  public Account(String name, String email) {
    this.name = name;
    checkEmail(email);
    this.email = email;
    reputation = 0;
  }

  public static void checkEmail(String email) {
    char[] temp = email.toCharArray();
    boolean symNotFound = true;
    for (char c : temp) {
      if (c == AT) {
        symNotFound = false;
        break;
      }
    }

    if (symNotFound) {
      throw new InvalidEmail(email);
    }
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  /**
   * Увеличивает репутацию.
   *
   * @param diff Разница между старым и новым значением, всегда положительная
   */
  public void increaseReputation(int diff) {
    if (diff > 0) {
      reputation += diff;
    }
  }

  /**
   * Уменьшает репутацию.
   *
   * @param diff Разница между старым и новым значением, всегда положительная
   */
  public void decreaseReputation(int diff) {
    if (diff > 0) {
      reputation -= diff;
    }
  }

  public int getReputation() {
    return reputation;
  }

  @Override
  public String toString() {
    return String.format("name: %s, e-mail: %s, reputation: %s", name, email, reputation);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Account other)) {
      return false;
    }

    return this.name.equalsIgnoreCase(other.name) && this.email.equalsIgnoreCase(other.email);
  }

  @Override
  public int hashCode() {
    return name.hashCode() * email.hashCode();
  }
}
