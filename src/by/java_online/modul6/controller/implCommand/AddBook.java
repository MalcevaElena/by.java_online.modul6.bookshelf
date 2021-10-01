package by.java_online.modul6.controller.implCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBook {
      public void enterToConsole (){
          StringBuilder enterBook = null;

          try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
              String line;

              System.out.println("Введите название книги: ");
              line = reader.readLine();
              enterBook.append(line+ " ");

              System.out.println("Введите автора: ");
              line = reader.readLine();
              enterBook.append(line+ " ");

              System.out.println("Введите год издания книги: ");
              line = reader.readLine();
              enterBook.append(line+ " ");

              System.out.println("Введите тип книги: Бумажная или Электронная. ");
              line = reader.readLine();
              enterBook.append(line);

          } catch (IOException e) {
              e.printStackTrace();
          }
      }
}
