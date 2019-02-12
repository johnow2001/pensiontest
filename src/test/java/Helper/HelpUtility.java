package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class HelpUtility {

    WebDriver driver;

    public HelpUtility(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(String page) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(page));
        return driver.getTitle();
    }

    public void writeByteChannelToLogFile() {

        try (FileChannel fc = (FileChannel) Files.newByteChannel(Path.of("log.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            LocalDateTime ldt = LocalDateTime.now();
            String strDateTime = ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

            String message = "Logging new start of test";
            String fullMessage = strDateTime.concat(" ").concat(message);

            int size = fullMessage.length();
            byte fm[] = fullMessage.getBytes();

            ByteBuffer buff = ByteBuffer.allocate(size);
            buff.put(fm, 0, size);
            buff.rewind();
            fc.write(buff);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path" + e.getMessage() + " " + e.getReason());
        } catch (IOException e) {
            System.out.println("IO exception" + e.getMessage());
        }
    }

    public void writeIoStreamChannelToFile() {

        try (OutputStream out = Files.newOutputStream(Path.of("log.txt"), StandardOpenOption.APPEND)) {

            String end = "Test has finished";
            LocalDateTime ldt = LocalDateTime.now();
            String endDateTime = ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
            String fullMessage = endDateTime.concat(" ").concat(end);

            byte[] fm = fullMessage.getBytes();
            out.write(fm);

            PrintWriter pw = new PrintWriter(out);
            pw.println();
            pw.println("\nStart new end message");
            pw.println(fullMessage);
            pw.println("\nEnd new end message");
            pw.flush();

        } catch (InvalidPathException | IOException e) {
            System.out.println("Exception raised " + e.getMessage());
        }
    }

    public void readMyConfigFile() {
        String propFilePath = "config\\config.properties";

        try (FileChannel fc = (FileChannel) Files.newByteChannel(Path.of(propFilePath), StandardOpenOption.READ)) {

            Scanner sc = new Scanner(fc);

            HashMap<String, String> configData = new HashMap<>();
            String key;
            String value;
            String line;
            String[] splitLine;

            while (sc.hasNext()) {
                line = sc.nextLine();
                splitLine = line.split("=");
                key = splitLine[0];
                value = splitLine[1];
                configData.put(key, value);
            }
            Set<Map.Entry<String, String>> set = configData.entrySet();
            for (Map.Entry<String, String> data : set) {
                System.out.println(data.getKey() + " : " +  data.getValue());
            }
        } catch (InvalidPathException | IOException | NoSuchElementException e) {
            System.out.println("Exception: " + e);
        }
    }

    public void writetoFileOldMethod(){
        File f = new File("log.txt");
        System.out.println("Exists = " + f.exists());
        System.out.println("Size = " + f.length());

        try(FileWriter fop = new FileWriter(f, true);
            BufferedWriter bop = new BufferedWriter(fop);
            PrintWriter pw = new PrintWriter(bop)){

            String message1 = "logging to log file with write char";
            String message2 = "DateTime in string = ";
            LocalDateTime ldt = LocalDateTime.now();
            String time = ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

            char c[] = message1.toCharArray();
            pw.write(c);
            pw.println('\n' + message2.concat(" ").concat(time));

        }
        catch (Exception e){
            System.out.println("Exception \n" +  e.getMessage());
        }


        try(OutputStream os = new FileOutputStream(f, true);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            PrintStream ps = new PrintStream(bos)) {

            String mess1 = "****buff op stream to file******";
            byte b[] = mess1.getBytes();
            ps.write(b);

            String mess2 = "buff op write with the println function";
            char[] c = mess2.toCharArray();
            ps.println(c);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try(InputStream ips = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(ips);
            InputStreamReader isr = new InputStreamReader(bis)){

            int num;
            char c[] = new char[1024];

            do {
                num = isr.read(c, 0, c.length);
                //System.out.println(c);
                isr.mark(1024);
                //isr.reset();
            } while (num != -1);
        }
        catch (Exception e){

        }

        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)){

            String line;
            while ((line = br.readLine()) != null){
                //System.out.println(line);
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try(FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr)){

            String line;
            while ((line = br.readLine()) != null){
                //System.out.println(line);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void  doCompare(){
        TreeSet<LocalDateTime> ts = new TreeSet<>(new MyCompare());
        for(int i=0; i<20; i++) {
            LocalDateTime ldt = LocalDateTime.now();
            Random r = new Random(10);
            ts.add(ldt.plusSeconds(r.nextInt(10)));
            ts.add(ldt.minusSeconds(r.nextInt(1000)));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }

         for(LocalDateTime time : ts){
             String t = time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
             System.out.println(t);
         }
    }
}


class MyCompare implements Comparator<LocalDateTime>{
    public int compare(LocalDateTime a, LocalDateTime b){
        return b.compareTo(a);
    }

}