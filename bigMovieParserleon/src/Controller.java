import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
//        System.out.println("Hello World!");
//        String naam = in.nextLine();
//        System.out.println("hallo " + naam + ". hoe gaat het met jou?");
        string str = "123nogeenswatlol";
        Pattern pattern = Pattern.compile(" \"\\W(.+?)\"\\s(([A-Za-z0-9?I/_.]+?))(?(?=\\s{{)\\s{{(.+?)}})(?(?=\\s{)\\s{(.+?)\\s(#(.+?))}\\s(.+)|\\s(.+))");
        Matcher matcher = pattern.matcher(str);
    }
}
