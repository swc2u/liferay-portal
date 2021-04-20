package languageact;

import com.liferay.portal.kernel.language.UTF8Control;
import java.util.Enumeration;
import java.util.ResourceBundle;
import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {"language.id=ur_IN"},
service = ResourceBundle.class
)
public class UrInlanguageactivators extends ResourceBundle {
	
	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
			"content.Language_ur_IN", UTF8Control.INSTANCE);
	
	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return _resourceBundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		return _resourceBundle.getObject(key);
	}

}
