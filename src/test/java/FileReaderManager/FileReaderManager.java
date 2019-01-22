package FileReaderManager;
import FileReader.*;

public class FileReaderManager {

    private static FileReaderManager man = new FileReaderManager();
    private static ConfigFileReader configReader;

    private FileReaderManager(){}

    public static FileReaderManager getInstance(){
        return man;
    }

    public ConfigFileReader getConfigReader(){
        if(configReader == null){
            configReader = new ConfigFileReader();
        }
        return  configReader;
    }
}
