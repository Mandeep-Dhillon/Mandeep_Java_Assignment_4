package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecordManager {
    private static final String FILE_PATH = "warrior_record.txt";
    private static int wins = 0;
    private static int losses = 0;

    static {
        readRecord(); // Initialize the record from the file
    }

    private static void readRecord() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        String line; 
        int lineNum = 0;
        while ((line = reader.readLine()) != null) {
            switch (lineNum) {
                case 0:
                    wins = Integer.parseInt(line); // wins
                    break;
                case 1:
                    losses = Integer.parseInt(line); // losses
                    break;
                }
                lineNum++;
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void writeRecord() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(wins + "\n" + losses);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void recordWin() {
        wins++;
        writeRecord();
    }

    public static void recordLoss() {
        losses++;
        writeRecord();
    }

    public static int getWins() {
        return wins;
    }

    public static int getLosses() {
        return losses;
    }
    public static String getRecordString() {
        return "Wins: " + wins + ", Losses: " + losses;
    }
}

