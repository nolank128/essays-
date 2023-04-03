package Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoggerFactory {
    public Logger createLogger() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String loggerType = props.getProperty("logger.type");
        String loggerTarget = props.getProperty("logger.target");
        String loggerUsername = props.getProperty("logger.username");
        String loggerPassword = props.getProperty("logger.password");

        try {
            Class<?> loggerClass = Class.forName(loggerType);
            if (loggerClass != null) {
                Object loggerObject = loggerClass.getConstructor(String.class, String.class, String.class)
                        .newInstance(loggerTarget, loggerUsername, loggerPassword);
                return (Logger) loggerObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("无效的日志类型");
    }
}

