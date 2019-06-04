package utils;
import java.io.IOException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;
public class XMLComp {
	public boolean compare(String xml1,String xml2) throws SAXException, IOException {
		//String xml1 = res1.getBody().asString();
		//String xml2 = res2.getBody().asString();

		XMLUnit.setIgnoreWhitespace(true);
		//assertXMLEquals(xml1, xml2);

		Diff diff = new Diff(xml1,xml2);
		//System.out.println(diff.similar());
		return diff.identical();
	}
}
