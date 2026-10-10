import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DefOscar {

   // Attributes
   private String[] tok;
   private String studentName;
   private String path;
   private String def;
   private int Score = 0;

   // Parameterize constructor taking the file path
   public DefOscar(String[] tok, String studentName, String path, int x) {
      this.tok = tok;
      this.studentName = studentName;
      this.path = path;
      this.Score = 0;
   }

   // Parameterize constructor taking definition from keyboard
   public DefOscar(String[] tok, String studentName, String def) {
      this.tok = tok;
      this.studentName = studentName;
      this.def = def;
      this.Score = 0;
   }

   // Method reading definition from the file path
   public String[] fileReader() {
      String[] words = {};
      try {
         File f = new File(this.path);
         Scanner sc = new Scanner(f);
         String line = "";
         while (sc.hasNextLine()) {
            line += sc.nextLine() + " ";
         }
         words = line.trim().split("\\s+");

         sc.close();
      } catch (IOException e) {
         System.out.println("File input output exception occured");
      }
      return words;
   }

   // Method reading definition from keyboard
   public String[] keyboardReader() {

      String[] words = {};
      if (this.def == null || this.def.trim().isEmpty()) {
         return words;
      } else {
         words = this.def.trim().split("\\s+");
         return words;
      }
   }

   // score() method gives Score according to the word matches with tok and add
   // score for every new word
   public int score(String[] s) {
      this.Score = 0;
      int[] counted = new int[tok.length];

      for (int i = 0; i < s.length; i++) {
         for (int j = 0; j < tok.length; j++) {

            if (s[i].equalsIgnoreCase(tok[j])
                  && counted[j] == 0) {

               this.Score++;
               counted[j] = 1;
               break;
            }
         }
      }
      return this.Score;
   }

   // Grading
   public String level() {
      String grade = "";
      if (this.Score > 6) {
         grade = "Excellent";
      } else if (this.Score > 3) {
         grade = "Good";
      } else {
         grade = "Basic";
      }
      return grade;
   }

   // Giving oscar award to the students who has higher score
   public static DefOscar oscarAward(DefOscar[] students) {
      if (students == null || students.length == 0) {
         return null;
      }

      DefOscar winner = students[0];

      for (int i = 1; i < students.length; i++) {
         if (students[i] != null && students[i].Score > winner.Score) {
            winner = students[i];
         }
      }
      return winner;
   }

   @Override
   public String toString() {
      String x = this.studentName + " | Classification " + this.level() + " | Grade " + this.Score;

      return x;
   }
}