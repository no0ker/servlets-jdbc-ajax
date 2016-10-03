package finder.db;

import java.io.*;

public class SqlHelper {
    public String getQuery(String filename) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File configFile = new File(classLoader.getResource("/sql/" + filename + ".sql").getFile());

        InputStream is = new FileInputStream(configFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        String line = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }

        return stringBuilder.toString();
    }
}
