import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * This class only exists for annotations.  It has no logic.
 * @author d_clo
 */
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@Configuration
@ComponentScan("com.dc.mixdb")
@PropertySource("app.properties")
public class AppConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
