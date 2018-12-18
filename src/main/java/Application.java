import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dc.mixdb.model.IAlbum;
import com.dc.mixdb.service.IAlbumService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		IAlbumService service = appContext.getBean(IAlbumService.class);
		List<IAlbum> l = service.findAll();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(i + " : " + l.get(i).toString());
		}
	}
}
