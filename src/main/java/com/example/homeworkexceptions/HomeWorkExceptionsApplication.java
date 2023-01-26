package com.example.homeworkexceptions;

import com.example.homeworkexceptions.exception.WrongLoginException;
import com.example.homeworkexceptions.exception.WrongPasswordException;

public class HomeWorkExceptionsApplication {

    public static void main(String[] args) {
        String login = "1234";
        String password = "1234123412341234122";
        String confirmPassword = "1234123412341234122";
        System.out.println(acceptThreeParametrs(login, password, confirmPassword));
    }

    public static boolean acceptThreeParametrs(String login, String password, String confirmPassword ) {
       boolean checklogin;
       boolean checkPassword;
       boolean checkLengthLogin;
        boolean checkLengthPassword;
        boolean checkPasswordMatching;
   try {
    checklogin = checkValidationCharacter(login);
    checkPassword = checkValidationCharacter(password);
    checkLengthLogin = checkLengthLogin(login);
    checkLengthPassword = checkLengthPassword(password);
    checkPasswordMatching = checkPasswordMatching(password, confirmPassword);
       } catch (WrongLoginException | WrongPasswordException exception){
      System.out.println(exception.getMessage());
      return false;
     }
      return checklogin && checkPassword && checkLengthLogin && checkLengthPassword && checkPasswordMatching;
      }

    public static boolean checkValidationCharacter (String checkWord){
        if (checkWord == null) {
            throw new NullPointerException("Введен null");
        } if (checkWord.matches("\\w+")){
            return true;
        }
        System.out.printf("Недопустимый символ вслоев - '%s'\n", checkWord);
        return false;
    }

    public static boolean checkLengthLogin (String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException ("Слишком длинный пароль");
        }
        return true;
    }

    public static boolean checkLengthPassword (String password){
        if (password.length() > 19) {
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;
    }

    public static boolean checkPasswordMatching (String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) return true;
            throw new WrongPasswordException("Пароли не совпадают");
        }
}

