package dsw.gerumap.app.logger;


import dsw.gerumap.app.core.observer.Subscriber;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements ErrorLogger, Subscriber {

    File file;

    public FileLogger() {
        createFile();
    }

    private void createFile(){

        file = new File("log.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(Message message){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter fw = new FileWriter("log.txt",true);
            fw.write("ERROR: "+ dtf.format(now) + " " + message.getText()+ " naziv greske: " +message.getType().toString().replace('_',' ') + "\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void log(Message message) {
        writeToFile(message);
    }

    @Override
    public void update(Object notification) {
        log((Message) notification);
    }
}
