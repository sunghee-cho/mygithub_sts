package db_jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration  //xml대신자바설정파일
@EnableEncryptableProperties  //암호화/복호화 메소드 클래스 위 선언. properties파일 내의 ENC() 인식
public class JasyptConfig {
	
	@Autowired
	Environment environment;
	
	@Bean("jasyptEncryptor")
	public StringEncryptor stringEncryptor(){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(environment.getProperty("jasypt.encryptor.password"));


        config.setPoolSize("1");
        encryptor.setConfig(config);
 
        return encryptor;
	}
	
}
