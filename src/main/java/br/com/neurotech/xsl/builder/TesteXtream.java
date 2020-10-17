package br.com.neurotech.xsl.builder;

import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class TesteXtream {
	public static Return transform(String xml) {
		
		XStream xstream = new XStream();
		xstream.processAnnotations(Return.class);
		xstream.processAnnotations(Bloco.class);
		xstream.processAnnotations(Field.class);
		xstream.processAnnotations(Input.class);
		xstream.processAnnotations(Site.class);
		xstream.addPermission(NoTypePermission.NONE);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		xstream.allowTypeHierarchy(Collection.class);
		xstream.allowTypesByWildcard(new String[] {
		    "br.com.neurotech.builder"
		});
		
		Return returnGtw = (Return) xstream.fromXML(xml);
		
		return returnGtw;
	}
}
