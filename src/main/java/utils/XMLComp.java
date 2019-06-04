package utils;
import java.io.IOException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;
public class XMLComp {
	public boolean compare(String xml1,String xml2) throws SAXException, IOException {

		XMLUnit.setIgnoreWhitespace(true);
		Diff diff = new Diff(xml1,xml2);
		//System.out.println(diff.similar());
		return diff.identical();
	}
}
