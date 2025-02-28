import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}

class Quiz {
    private final String[] questions = {
            "Q1: What is the orange part of an egg called?\nA) Yolk\nB) Shell\nC) Albumen\nD) Chalaza",
            "Q2: How many legs do insects have?\nA) Four\nB) Six\nC) Eight\nD) Ten",
            "Q3: What is a baby kangaroo called?\nA) Cub\nB) Pup\nC) Joey\nD) Calf",
            "Q4: What is the closest planet to the Sun?\nA) Venus\nB) Mars\nC) Mercury\nD) Earth",
            "Q5: In which country can you find the Eiffel Tower?\nA) Italy\nB) Spain\nC) France\nD) Germany",
            "Q6: How many days are there in a year?\nA) 365\nB) 366\nC) 360\nD) 364",
            "Q7: How many players are in a soccer team?\nA) Nine\nB) Eleven\nC) Ten\nD) Twelve",
            "Q8: Where do polar bears live?\nA) Antarctica\nB) The Arctic\nC) Greenland\nD) Iceland",
            "Q9: Which is faster, light or sound?\nA) Light\nB) Sound",
            "Q10: How many letters are in the English alphabet?\nA) Twenty-four\nB) Twenty-five\nC) Twenty-six\nD) Twenty-seven"
    };

    private final char[] answers = { 'a', 'b', 'c', 'c', 'c', 'a', 'b', 'b', 'a', 'c' };

    public void startQuiz() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int correct = 0, wrong = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            char ans = input.next().charAt(0);
            if (ans == answers[i]) {
                correct++;
            } else {
                wrong++;
            }
        }

        double percentage = ((double) correct / questions.length) * 100;

        System.out.println("The total marks are : 100");
        System.out.println("Your marks are : " + (correct * 10));
        System.out.println("Total questions are : " + questions.length);
        System.out.println("Your correct answers are : " + correct + "\nYour wrong answers are : " + wrong);
        System.out.println("Your percentage is : " + percentage + "%");
    }
}
