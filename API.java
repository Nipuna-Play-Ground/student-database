import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

void main() throws IOException, InterruptedException {
    final Scanner SCANNER = new Scanner(System.in);


    String storeIds = "";
    String storeNames = "";
    String storePFMarks = "";
    String storeOOPMarks = "";
    int longestName = 0;
    int setId = 0;
    int highestTotal = 0;
    double highestAverage = 0;
    int lowestTotal = 200;
    double lowestAverage = 100;


    main:
    while (true) {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        System.out.println("==================================");
        System.out.println("\033[32;1;7m   Welcome to Student Database    \033[0m");
        System.out.println("==================================");

        System.out.println();
        System.out.println("1. Add New Result");
        System.out.println("2. Delete Result");
        System.out.println("3. View Student Status");
        System.out.println("4. View Result Sheet");
        System.out.println("5. Exit");

        System.out.println();
        System.out.print("Enter your command: ");
        int userInput = SCANNER.nextInt();
        SCANNER.skip("\n");
        switch (userInput) {
            case 1 -> {
                case1:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("==================================");
                    System.out.println("\033[32;1;7m          Add New Result          \033[0m");
                    System.out.println("==================================");

                    System.out.println();
                    System.out.print("Enter Student Name: ");
                    String name = SCANNER.nextLine();
                    if (name.isBlank()) {
                        System.out.println("\033[31mInvalid Name\033[0m");
                        Thread.sleep(500);
                        continue case1;
                    } else {
                        int total = 0;
                        double average = 0;
                        storeIds += STR."S\{String.format("%03d", ++setId )},";
                        storeNames += STR."\{name},";
                        if (name.length() > longestName) longestName = name.length();
                        pFLoop:
                        while (true){
                            System.out.print("Enter the PF marks: ");
                            int pFMarks = SCANNER.nextInt();
                            if (pFMarks < 0 || pFMarks > 100) {
                                System.out.println("\033[31mInvalid Marks\033[0m");
                                Thread.sleep(500);
                                continue pFLoop;
                            }
                            else {
                                storePFMarks += STR."\{pFMarks},";
                                total += pFMarks;
                                break pFLoop;
                            }
                        }
                        oOPLoop:
                        while (true){
                            System.out.print("Enter the OOP marks: ");
                            int oOPMarks = SCANNER.nextInt();
                            if (oOPMarks < 0 || oOPMarks > 100) {
                                System.out.println("\033[31mInvalid Marks\033[0m");
                                Thread.sleep(500);
                                continue oOPLoop;
                            }
                            else {
                                storeOOPMarks += STR."\{oOPMarks},";
                                total += oOPMarks;
                                break oOPLoop;
                            }

                        }
                        if (total > highestTotal) {
                            highestTotal = total;
                            highestAverage = total/2.;
                        }
                        if (total < lowestTotal) {
                            lowestTotal = total;
                            lowestAverage = total/2.;
                        }
                        System.out.println("\033[32mAdded Successfully!\033[0m");

                        System.out.print("Do you want to add another student? (y/n)");
                        command:
                        while (true) {
                            String command = SCANNER.next();
                            if (command.equalsIgnoreCase("y")){
                                SCANNER.skip("\n");
                                continue case1;
                            }
                            else if (command.equalsIgnoreCase("n")) {
                                SCANNER.skip("\n");
                                continue main;
                            }
                            else continue command;
                        }
                    }
                }

            }
            case 2 -> {
                case2:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("==================================");
                    System.out.println("\033[32;1;7m         Delete Result            \033[0m");
                    System.out.println("==================================");

                    System.out.print("Enter Student ID (Sxxx): ");
                    String id = SCANNER.next();
                    if (storeIds.contains(id)) {
                        int count = storeIds.length() - storeIds.replace(",", "").length();
                        int commaIndexId = 0;
                        int commaIndexName = 0;
                        int commaIndexPFMarks = 0;
                        int commaIndexOOPMarks = 0;
                        for (int turns = 0; turns < count && count == (storeIds.length() - storeIds.replace(",", "").length()); turns++) {
                            String idCheck = storeIds.substring(commaIndexId, (commaIndexId = storeIds.indexOf(",", commaIndexId) + 1) - 1);
                            String nameCheck = storeNames.substring(commaIndexName, (commaIndexName = storeNames.indexOf(",", commaIndexName) + 1) - 1);
                            String pFMarksCheck = storePFMarks.substring(commaIndexPFMarks, (commaIndexPFMarks = storePFMarks.indexOf(",", commaIndexPFMarks) + 1) - 1);
                            String oOPMarksCheck = storeOOPMarks.substring(commaIndexOOPMarks, (commaIndexOOPMarks = storeOOPMarks.indexOf(",", commaIndexOOPMarks) + 1) - 1);
                            if (id.equals(idCheck)) {
                                storeIds = storeIds.replace(STR."\{idCheck},", "");
                                storeNames = storeNames.replace(STR."\{nameCheck},", "");
                                storePFMarks = storePFMarks.replace(STR."\{pFMarksCheck},", "");
                                storeOOPMarks = storeOOPMarks.replace(STR."\{oOPMarksCheck},", "");
                            }
                        }
                        System.out.println("\033[32mDeleted Successfully!\033[0m");
                        if (count != storeIds.length() - storeIds.replace(",", "").length()) {
                            commaIndexPFMarks = 0;
                            commaIndexOOPMarks = 0;
                            highestTotal = 0;
                            highestAverage = 0;
                            lowestTotal = 200;
                            lowestAverage = 100;
                            int total = 0;
                            double average = 0;
                            count = storeIds.length() - storeIds.replace(",", "").length();

                            for (int turns = 0; turns < count; turns++) {
                                String pFMarksCheck = storePFMarks.substring(commaIndexPFMarks, (commaIndexPFMarks = storePFMarks.indexOf(",", commaIndexPFMarks) + 1) - 1);
                                String oOPMarksCheck = storeOOPMarks.substring(commaIndexOOPMarks, (commaIndexOOPMarks = storeOOPMarks.indexOf(",", commaIndexOOPMarks) + 1) - 1);
                                total = Integer.parseInt(pFMarksCheck) + Integer.parseInt(oOPMarksCheck);
                                average = total / 2.;
                                if (total > highestTotal) {
                                    highestTotal = total;
                                    highestAverage = average;
                                }
                                if (total < lowestTotal) {
                                    lowestTotal = total;
                                    lowestAverage = average;
                                }
                            }
                        }
                    } else {
                        System.out.println("\033[31mNot found!\033[0m");
                        Thread.sleep(500);
                    }
                    System.out.println("Do you want to go back? (y/n)");
                    command:
                    while (true) {
                        String command = SCANNER.next();
                        if (command.equalsIgnoreCase("n")) {
                            SCANNER.skip("\n");
                            continue case2;
                        } else if (command.equalsIgnoreCase("y")) {
                            SCANNER.skip("\n");
                            continue main;
                        } else continue command;
                    }
                }
            }
            case 3 -> {
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("==================================");
                    System.out.println("\033[32;1;7m       View Student Status        \033[0m");
                    System.out.println("==================================");

                    System.out.print("Enter Student ID (Sxxx): ");
                    String id = SCANNER.next();
                    if (storeIds.contains(id)) {
                        int count = storeIds.length() - storeIds.replace(",", "").length();
                        int commaIndexId = 0;
                        int commaIndexName = 0;
                        int commaIndexPFMarks = 0;
                        int commaIndexOOPMarks = 0;
                        int totalMarks = 0;
                        double averageMarks = 0;
                        for (int turns = 0; turns < count && count == (storeIds.length() - storeIds.replace(",", "").length()); turns++) {
                            String idCheck = storeIds.substring(commaIndexId, (commaIndexId = storeIds.indexOf(",", commaIndexId) + 1) - 1);
                            String nameCheck = storeNames.substring(commaIndexName, (commaIndexName = storeNames.indexOf(",", commaIndexName) + 1) - 1);
                            String pFMarksCheck = storePFMarks.substring(commaIndexPFMarks, (commaIndexPFMarks = storePFMarks.indexOf(",", commaIndexPFMarks) + 1) - 1);
                            String oOPMarksCheck = storeOOPMarks.substring(commaIndexOOPMarks, (commaIndexOOPMarks = storeOOPMarks.indexOf(",", commaIndexOOPMarks) + 1) - 1);
                            if (id.equals(idCheck)) {
                                System.out.println(STR."Student ID:    \{idCheck}");
                                System.out.println(STR."Student Name:  \{nameCheck}");
                                System.out.println(STR."PF Marks:      \{pFMarksCheck}");
                                System.out.println(STR."OOP Marks:     \{oOPMarksCheck}");
                                System.out.println(STR."Total Marks:   \{totalMarks = Integer.parseInt(pFMarksCheck) + Integer.parseInt(oOPMarksCheck)}");
                                System.out.printf(STR."Average Marks: %.2f\n", averageMarks = totalMarks / 2.);
                            }
                        }
                    } else {
                        System.out.println("\033[31mNot found!\033[0m");
                        Thread.sleep(500);
                    }
                    System.out.println();
                    System.out.println("Do you want to go back? (y)");
                    String command = SCANNER.next();
                    if (command.equalsIgnoreCase("y")) continue main;
                }
            }
            case 4 -> {
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("==================================");
                    System.out.println("\033[32;1;7m           Result Sheet           \033[0m");
                    System.out.println("==================================");

                    final String RED = "\033[31m";
                    final String GREEN = "\033[32m";
                    final String BLUENBOLD = "\033[34;1;7m";
                    final String RESET = "\033[0m";

                    String horizontalLine = STR."+\{"-".repeat(6)}+\{"-".repeat(longestName == 0? 6 : longestName + 2)}+\{"-".repeat(10)}+\{"-".repeat(11)}+\{"-".repeat(7)}+\{"-".repeat(9)}+\{"-".repeat(7)}+";
                    String header = String.format(STR."\{BLUENBOLD}|%-6s|%-\{longestName == 0? 6 : longestName + 2}s|%-10s|%-11s|%-7s|%-9s|%-7s|\{RESET}\n", "ID", "NAME", "PF MARKS", "OOP MARKS", "TOTAL", "AVERAGE", "GRADE");

                    System.out.println(horizontalLine);
                    System.out.printf(header);
                    System.out.println(horizontalLine);

                    int count = storeNames.length() - storeNames.replace(",", "").length();
                    int commaIndex = 0;
                    int total = 0;
                    double average = 0;
                    int commaIndexId = 0;
                    int commaIndexName = 0;
                    int commaIndexPFMarks = 0;
                    int commaIndexOOPMarks = 0;
                    String grade = "";

                    if (count == 0) System.out.printf(STR."|%-62s|\n", "No Detais Present!");
                    else {
                        for (int turns = 0; turns < count && count == (storeIds.length() - storeIds.replace(",", "").length()); turns++) {
                            String idCheck = storeIds.substring(commaIndexId, (commaIndexId = storeIds.indexOf(",", commaIndexId) + 1) - 1);
                            String nameCheck = storeNames.substring(commaIndexName, (commaIndexName = storeNames.indexOf(",", commaIndexName) + 1) - 1);
                            String pFMarksCheck = storePFMarks.substring(commaIndexPFMarks, (commaIndexPFMarks = storePFMarks.indexOf(",", commaIndexPFMarks) + 1) - 1);
                            String oOPMarksCheck = storeOOPMarks.substring(commaIndexOOPMarks, (commaIndexOOPMarks = storeOOPMarks.indexOf(",", commaIndexOOPMarks) + 1) - 1);
                            total = Integer.parseInt(pFMarksCheck) + Integer.parseInt(oOPMarksCheck);
                            average = total / 2.;
                            grade = average >= 75 ? "A+" : average >= 70 ? "A" : average >= 65 ? "B+" : average >= 60 ? "B" : average >= 55 ? "C" : average >= 45 ? "S" : "F";
                            String details = String.format(STR."|%-6s|%-\{longestName == 0 ? 6 : longestName + 2}s|%-10s|%-11s|%-7d|%-9.2f|%-7s|\n", idCheck, nameCheck, pFMarksCheck, oOPMarksCheck, total, average, grade);
                            System.out.printf(total == highestTotal ? STR."\{GREEN}\{details}\{RESET}" : total == lowestTotal ? STR."\{RED}\{details}\{RESET}" : STR."\{details}");
                        }
                    }
                    System.out.println(horizontalLine);
                    System.out.println();
                    System.out.println("Do you want to go back? (y)");
                    String command = SCANNER.next();
                    if (command.equalsIgnoreCase("y")) continue main;
                }
            }
            case 5 -> {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                System.exit(0);
            }
            default -> {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                continue main;
            }
        }
    }
}