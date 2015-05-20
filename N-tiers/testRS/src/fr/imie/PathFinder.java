package fr.imie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Path;

public class PathFinder {

	public String getRootPath(Class classToExplore) {
		String retour = null;
		for (Annotation annotation : classToExplore.getDeclaredAnnotations()) {
			// System.out.println(annotation.toString());
			if (annotation instanceof Path) {
				Path myAnnotation = (Path) annotation;
				// System.out.println("value: " + myAnnotation.value());
				retour = "/".concat(myAnnotation.value());
			}
		}
		return retour;
	}

	public String getServicePath(Class classToExplore, Class annotationService) {
		String retour = getRootPath(classToExplore);
		String path = "";
		Method[] methods = classToExplore.getMethods();
		Boolean findedMethod = false;
		for (Method method : methods) {
			for (Annotation annotation : method.getDeclaredAnnotations()) {

				// System.out.println(annotation.toString());
				if (annotationService.isInstance(annotation)) {
					findedMethod = true;
					// Path myAnnotation = (Path) annotation;
					// System.out.println("value: " + myAnnotation.value());
					System.out.println(annotation.toString());
					// retour=myAnnotation.value();
				}

				if (Path.class.isInstance(annotation)) {
					Path myAnnotation = (Path) annotation;
					// System.out.println("value: " + myAnnotation.value());
					path = myAnnotation.value();
					// retour=myAnnotation.value();
				}
			}

		}
		if (findedMethod && path.length() > 0) {
			retour = retour.concat(path);
		}
		return retour;
	}

	public String getServicePath(Class classToExplore, String methodeName) {
		String retour = getRootPath(classToExplore);
		String path = "";
		Method[] methods = classToExplore.getMethods();
		Boolean findedMethod = false;
		for (Method method : methods) {
			if (method.getName().contains(methodeName)) {
				for (Annotation annotation : method.getDeclaredAnnotations()) {

					if (Path.class.isInstance(annotation)) {
						Path myAnnotation = (Path) annotation;
						// System.out.println("value: " + myAnnotation.value());
						path = myAnnotation.value();
						// retour=myAnnotation.value();
						findedMethod=true;
					}
				}
			}
		}
		if (findedMethod && path.length() > 0) {
			retour = retour.concat(path);
		}
		return retour;
	}

	public String getServicePath(Class classToExplore, Class annotationService,
			Object[] params) {
		String retour = getServicePath(classToExplore, annotationService);
		retour = replaceParam(retour, params);
		return retour;
	}
	
	public String getServicePath(Class classToExplore, String methodeName,
			Object[] params) {
		String retour = getServicePath(classToExplore, methodeName);
		retour = replaceParam(retour, params);
		return retour;
	}

	public String replaceParam(String path,Object[] params){
		String retour=path;
		Pattern pattern = Pattern.compile("\\w*(\\{\\w*\\})\\w*");
		Matcher m = pattern.matcher(retour);
		StringBuffer sb = new StringBuffer();
		int count = 0;
		while(m.find()) {
			    m.appendReplacement(sb, params[count].toString());
			    count++;
		}
		
		m.appendTail(sb);
		retour=sb.toString();
		return retour;
	}
}
