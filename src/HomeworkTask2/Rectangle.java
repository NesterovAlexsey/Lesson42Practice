package HomeworkTask2;

//Задача 2* (не обязательно)
//    Создайте класс Rectangle (прямоугольник).
//
//    При создании класс должен получать длины сторон.
//    Сохраните их в памяти как поля (атрибуты) класса "длина" и "ширина".
//
//    При попытке сравнить два прямоугольника они должны оказываться одинаковыми,
//    если сами прямоугольники как геометрические фигуры равны
//    - если их можно совместить, повернув и наложив друг на друга.

import java.util.Objects;

public class Rectangle {

  final private int length;
  final private int width;

  public Rectangle(int length, int width) {
    this.length = length;
    this.width = width;
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Rectangle whatever)) {
      return false;
    }

    return ((this.length == whatever.getLength()) || (this.length == whatever.getWidth())) &&
        ((this.width == whatever.getLength()) || (this.width == whatever.getWidth()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(length, width);
  }
}
