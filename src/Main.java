import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("myfile", true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader.readLine();
            fos.write(s.getBytes());
            fos.flush();
            System.out.println("写入成功");
            fis = new FileInputStream("myfile");
            byte[] bytes = new byte[1048];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                String s1 = new String(bytes, 0, readCount);
                System.out.println(s1);
            }
            System.out.println("执行成功");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}