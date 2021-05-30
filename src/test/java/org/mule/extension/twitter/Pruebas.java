package org.mule.extension.twitter;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.extension.entity.DirectMessage;
import org.mule.extension.entity.Event;

public class Pruebas {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		DirectMessage m = new DirectMessage("henrysdf","Hello World");
		try {
			System.out.println(mapper.writeValueAsString(m));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
