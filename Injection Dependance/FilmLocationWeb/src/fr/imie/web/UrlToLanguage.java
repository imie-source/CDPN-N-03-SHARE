package fr.imie.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@Named("urlToLanguage")
public class UrlToLanguage {

	@Inject
	HttpServletRequest httpServletRequest;

	private Language language = null;

	public Language languageIdentification() {
		Matcher m = Pattern.compile("[\\w*\\/]*\\/(\\S*)").matcher(
				httpServletRequest.getRequestURI());
		
		String urlLang = "";
		if (m.find()) {
			urlLang = m.group(1);
		}

		Language retour = Language.all;

		if (urlLang.compareTo("fr") == 0) {
			retour = Language.fr;
		}

		if (urlLang.compareTo("us") == 0) {
			retour = Language.us;
		}
		
		language = retour;

		return retour;
	}

	public Language getLanguage() {
		return language;
	}
	
	

}
