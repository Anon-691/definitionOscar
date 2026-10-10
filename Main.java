import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter definition");
        String def = sc.nextLine();

        String[] tok = { "inheritance", "relationship", "parent", "child", "class", "methods", "attributes",
                "properties", "deriving" };

        DefOscar student1 = new DefOscar(tok, "Ahmed",
                "C:\\Users\\AA COMPUTER\\Documents\\DefOscar\\ahmedDefinition.txt",
                0);
        DefOscar student2 = new DefOscar(tok, "Ali", def);

        student1.score(student1.fileReader());
        student1.level();

        student2.score(student2.keyboardReader());
        student2.level();

        System.out.println(student1.toString());
        System.out.println(student2.toString());

        DefOscar[] students = { student1, student2 };

        DefOscar winner = DefOscar.oscarAward(students);
        System.out.println("\n Oscar Award goes to ");
        System.out.println(winner);

        sc.close();

    }
}