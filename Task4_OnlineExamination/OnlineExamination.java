import java.util.Scanner;

public class OnlineExamination {

    static Scanner sc = new Scanner(System.in);

    static String username = "student";
    static String password = "1234";

    static boolean login() {

        System.out.println("===== LOGIN =====");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if(user.equals(username) && pass.equals(password)) {
            System.out.println("\nLogin Successful!");
            return true;
        }

        System.out.println("Invalid Credentials!");
        return false;
    }

    static void updateProfile() {

        System.out.print("Enter New Username: ");
        username = sc.nextLine();

        System.out.println("Username Updated Successfully!");
    }

    static void updatePassword() {

        System.out.print("Enter New Password: ");
        password = sc.nextLine();

        System.out.println("Password Updated Successfully!");
    }
    static void startExam() {
        long startTime = System.currentTimeMillis();
        System.out.println("Exam Duration: 20 Seconds");
        System.out.println("Timer Started...");

    int score = 0;

    System.out.println("\n===== EXAM STARTED =====");


    if ((System.currentTimeMillis() - startTime) / 1000 > 10) {
    System.out.println("\nTime Up! Auto Submitting Exam...");
    return;
}
    System.out.println("\nQ1. Java is a ?");
    System.out.println("A. Programming Language");
    System.out.println("B. Browser");
    System.out.println("C. Database");
    System.out.println("D. Operating System");
    System.out.print("Answer: ");

    char ans1 = sc.nextLine().toUpperCase().charAt(0);

    if(ans1 == 'A')
        score++;

    System.out.println("Elapsed Time = " +
    ((System.currentTimeMillis() - startTime) / 1000) + " sec");

    if ((System.currentTimeMillis() - startTime) / 1000 > 10) {
    System.out.println("\nTime Up! Auto Submitting Exam...");
    return;
}
    System.out.println("\nQ2. Which company developed Java?");
    System.out.println("A. Google");
    System.out.println("B. Microsoft");
    System.out.println("C. Sun Microsystems");
    System.out.println("D. Apple");
    System.out.print("Answer: ");

    char ans2 = sc.nextLine().toUpperCase().charAt(0);

    if(ans2 == 'C')
        score++;

    if ((System.currentTimeMillis() - startTime) / 1000 > 10) {
    System.out.println("\nTime Up! Auto Submitting Exam...");
    return;
}
    System.out.println("\nQ3. Which keyword is used to create an object?");
    System.out.println("A. class");
    System.out.println("B. new");
    System.out.println("C. object");
    System.out.println("D. create");
    System.out.print("Answer: ");
   
    char ans3 = sc.nextLine().toUpperCase().charAt(0);

    if(ans3 == 'B')
        score++;

    if ((System.currentTimeMillis() - startTime) / 1000 > 10) {
    System.out.println("\nTime Up! Auto Submitting Exam...");
    return;
}
    System.out.println("\nQ4. Java is ?");
    System.out.println("A. Platform Independent");
    System.out.println("B. Platform Dependent");
    System.out.println("C. Browser");
    System.out.println("D. Compiler");
    System.out.print("Answer: ");

    char ans4 = sc.nextLine().toUpperCase().charAt(0);

    if(ans4 == 'A')
        score++;

    if ((System.currentTimeMillis() - startTime) / 1000 > 10) {
    System.out.println("\nTime Up! Auto Submitting Exam...");
    return;
}
    System.out.println("\nQ5. Extension of Java source file?");
    System.out.println("A. .class");
    System.out.println("B. .html");
    System.out.println("C. .java");
    System.out.println("D. .txt");
    System.out.print("Answer: ");

    char ans5 = sc.nextLine().toUpperCase().charAt(0);

    if(ans5 == 'C')
        score++;

    System.out.println("\n===== RESULT =====");
    System.out.println("Correct Answers : " + score);
    System.out.println("Total Questions : 5");

    double percentage = (score * 100.0) / 5;

    System.out.println("Score : " + percentage + "%");
}

    public static void main(String[] args) {

        if(!login()) {
            return;
        }

        while(true) {

            System.out.println("\n===== ONLINE EXAMINATION =====");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {

                case 1:
                    updateProfile();
                    break;

                case 2:
                    updatePassword();
                    break;

                case 3:
                    startExam();
                    break;

                case 4:
                    System.out.println("Logged Out Successfully!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
    

