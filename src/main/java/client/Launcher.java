package client;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Launcher {

	public static void main(String[] args) throws WrongInputException_Exception, DatatypeConfigurationException {
		AJSService ajsService = new AJSService();
		DefaultAJSService port = ajsService.getDefaultAJSServicePort();

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

		String suuid = port.insertStudent("Captain", "Morgain");
		System.out.println("inserted student " + suuid);

		String cuuid = port.insertCourse("KOPR");
		System.out.println("inserted course " + cuuid);

		String suuid2 = port.insertStudent("Dragonslayer", "Ornstein");
		List<String> attendees = new ArrayList<>();
		attendees.add(suuid);
		attendees.add(suuid2);
		String auuid = port.insertAttendance(cuuid, xmlCalendar, attendees);
		System.out.println("inserted attendance " + auuid);

		List<String> attendeesOfAttendance = port.findAttendees(auuid);
		for (String string : attendeesOfAttendance) {
			System.out.println("attendee " + string);
		}

		String auuid2 = port.insertAttendance(cuuid, xmlCalendar, attendees);
		List<Attendance> attendancies = port.attendancesOfAttendee(suuid);
		for (Attendance attendance : attendancies) {
			System.out.println("one of student's attendancies is: " + attendance.getUuid());
		}

	}
}
