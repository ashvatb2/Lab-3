import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int count = 0;
        String s = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(s);
        String[] array = s.split(" ");

        for (int i = 0; i < array.length; i++) {
            String a = array[i].toLowerCase();
            if ((a.contains("prince") || (a.contains("prince,")))) {
                count++;
            }
        }
        //
        System.out.println("Count of Prince: "+count);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
