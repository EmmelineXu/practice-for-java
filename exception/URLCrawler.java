import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class URLCrawler {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Traverse the Web from a starting url
    }

    public static void crawler(String startingURL) throws IOException {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            listOfTraversedURLs.add(urlString);
            System.out.println("Crawl " + urlString);

            for (String s: getSubURLs(urlString)) {
                if (!listOfTraversedURLs.contains(s) &&
                        !listOfPendingURLs.contains(s))
                    listOfPendingURLs.add(s);
            }
        }
        WriteURL(listOfTraversedURLs);
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }

        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;
    }

    public static void WriteURL(ArrayList<String> list) throws java.io.IOException {
        java.io.File file = new java.io.File("urls.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        // Write formatted output to the file
        for(String e: list){
            output.println(e);
        }

        // Close the file
        output.close();
    }
}