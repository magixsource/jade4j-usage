package com.linpeng.jade4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.neuland.jade4j.Jade4J.Mode;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.exceptions.JadeCompilerException;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import de.neuland.jade4j.template.TemplateLoader;

/**
 * Usage of Jade4j
 * 
 * @author linpeng
 *
 */
public class Main {

	public static void main(String[] args) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			long start = System.currentTimeMillis();
			JadeConfiguration config = new JadeConfiguration();
			config.setMode(Mode.HTML);
			config.setPrettyPrint(true);
			TemplateLoader loader = new FileTemplateLoader(
					"./resources/templates/", "UTF-8");
			config.setTemplateLoader(loader);
			JadeTemplate template = config.getTemplate("index");
			model.put("title", "我是一个可爱的标题");
			String html = config.renderTemplate(template, model);
			System.out.println(html);
			System.out.println((System.currentTimeMillis() - start));
		} catch (JadeCompilerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
