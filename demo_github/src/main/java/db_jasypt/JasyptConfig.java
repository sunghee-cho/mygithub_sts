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
        //config.setPassword("1234");
        config.setPassword(environment.getProperty("jasypt.encryptor.password"));
        //application.properties + JasyptConfig.java --> github push
        //암호화비번-직접 소스상 기록->외부환경설정변수값 읽어오자
        //자바클래스 실행-환경변수 읽어서 사용
        //-Djasypt.encryptor.password=1234

        config.setPoolSize("1");
        encryptor.setConfig(config);
        System.out.println("=== JasyptConfig 실행결과 ===");
        System.out.println(encryptor.decrypt("FqmbbYNR1aomoaWZffcpEAQrUGBgLKDe92S9+ol0Nkj+UNaysDnF9g=="));
        System.out.println(encryptor.decrypt("2oLm+I2F0Ln07Phtxgs43xBVjgK1yWbC/lLdjsBhbA+s9a8ndzjJQ0v4EyknOgM6"));
        System.out.println(encryptor.decrypt("nZ9WjYcw76FaW6KeCA4GuQG6p+Wblz4G"));
        System.out.println(encryptor.decrypt("6HpuqwUU1WTtfa/YdbWccM6seGPrIlhK"));
        System.out.println("=========================");
        System.out.println(encryptor);
        return encryptor;
	}
	
}
