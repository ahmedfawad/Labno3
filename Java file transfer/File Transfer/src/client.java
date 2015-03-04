import java.net.*;
import java.io.*;
public class client
{
    public static void main (String [] args ) throws IOException
{
    int filesize=1022386;
    int bytesRead;
    int currentTot = 0;
    Socket socket = new Socket("127.0.0.1",55557);
    byte [] bytearray = new byte [filesize];
    System.out.println("Attempting  to create connection ");
    InputStream is = socket.getInputStream();
    FileOutputStream fos = new FileOutputStream("copy.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bytesRead = is.read(bytearray,0,bytearray.length);
    currentTot = bytesRead;
    do { bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
        if(bytesRead >= 0) currentTot += bytesRead; }
    while(bytesRead > -1);
    bos.write(bytearray, 0 , currentTot);
    System.out.println("File Recieved");
    bos.flush();
    bos.close();
    socket.close();
}
}

