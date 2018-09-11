package opgave2multiplechoice;

import java.util.Arrays;

public class MultipleChoice {
    private char[] correctAnswer = { 'B', 'C', 'A', 'A', 'B', 'A', 'C', 'D', 'A', 'C' };

    private char[][] studentAnswers;

    public MultipleChoice(int numberOfStudents) {
        studentAnswers = new char[numberOfStudents][10];
        for (int i = 0; i < studentAnswers.length; i++) {
            for (int j = 0; j < studentAnswers[i].length; j++) {
                int tal = (int) (Math.random() * 4); // tal mellem 0-3
                char c = (char) (tal + 'A');
                studentAnswers[i][j] = c;
            }
        }
    }

    public void printStudentAnswers() {
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print("Student " + (i + 1) + " resultat: ");
            for (int j = 0; j < studentAnswers[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(studentAnswers[i][j]);
            }
            System.out.println();
        }
    }

    public void printCorrectAnswers() {
        System.out.println("De korrekte svar:  " + Arrays.toString(correctAnswer));
    }

    /**
     * Udskriver for hver studerende antallet af rigtige svar
     */
    public void printCorrectAnswersPrStudent() {
        int[] studentCorrectAnswers = new int[studentAnswers.length];

        for (int row = 0; row < studentAnswers.length; row++) {
            for (int col = 0; col < correctAnswer.length; col++) {
                if (studentAnswers[row][col] == correctAnswer[col]) {
                    studentCorrectAnswers[row]++;
                }
            }
        }

        for (int i = 0; i < studentCorrectAnswers.length; i++) {
            System.out.println("Student " + (i + 1) + " correct answers: " + studentCorrectAnswers[i]);
        }
    }

    /**
     * Udskriver for hver spørgsmål antallet af rigtige svar
     */
    public void printCorrectAnswerPrQuestion() {
        int[] questionCorrectAnswers = new int[correctAnswer.length];

        for (int row = 0; row < studentAnswers.length; row++) {
            for (int col = 0; col < correctAnswer.length; col++) {
                if (studentAnswers[row][col] == correctAnswer[col]) {
                    questionCorrectAnswers[col]++;
                }
            }
        }

        for (int i = 0; i < questionCorrectAnswers.length; i++) {
            System.out.println("Question " + (i + 1) + " correct answers: " + questionCorrectAnswers[i]);
        }
    }

}
