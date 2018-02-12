package client;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mysql.cj.jdbc.MysqlDataSource;

import client.AJSService;
import client.DefaultAJSService;
import client.Attendance;

public class AJSServiceTest {

	private AJSService ajsService;
	private DefaultAJSService port;
	private JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void setUpClass() {

	}

	@AfterClass
	public static void tearDownClass() {

	}

	@Before
	public void setUp() {
		ajsService = new AJSService();
		port = ajsService.getDefaultAJSServicePort();
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("cvika");
		dataSource.setURL("jdbc:mysql://localhost/cvika?serverTimezone=Europe/Bratislava");
		dataSource.setUser("root");
		dataSource.setPassword("yareyare");
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@After
	public void tearDown() {
	}

	@Test
	public void testInsertStudent() {
		System.out.println("insertStudent");
		String suuid = port.insertStudent("Captain", "Morgain");
		String UUIDForMysql = ("'" + suuid + "'");
		String result = jdbcTemplate.queryForObject(SQLQueries.NAME_OF_STUDENT + UUIDForMysql, String.class);
		assertEquals("Captain", result);
		result = jdbcTemplate.queryForObject(SQLQueries.SURNAME_OF_STUDENT + UUIDForMysql, String.class);
		assertEquals("Morgain", result);
		jdbcTemplate.update(SQLQueries.DELETE_STUDENT + UUIDForMysql);
	}

	@Test
	public void testInsertCourse() {
		System.out.println("insertCourse");
		String cuuid = port.insertCourse("KOPR");
		String UUIDForMysql = ("'" + cuuid + "'");
		String result = jdbcTemplate.queryForObject(SQLQueries.NAME_OF_COURSE + UUIDForMysql, String.class);
		assertEquals("KOPR", result);
		jdbcTemplate.update(SQLQueries.DELETE_COURSE + UUIDForMysql);
	}

	@Test
	public void testInsertAttendance() throws DatatypeConfigurationException, WrongInputException_Exception {
		System.out.println("insertAttendance");
		String cuuid = port.insertCourse("KOPR");
		String CUUIDForMysql = ("'" + cuuid + "'");
		String suuid = port.insertStudent("Executioner", "Smough");
		String SUUIDForMysql = ("'" + suuid + "'");
		List<String> attendees = new ArrayList<>();
		attendees.add(suuid);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		String auuid = port.insertAttendance(cuuid, xmlCalendar, attendees);
		String AUUIDForMysql = ("'" + auuid + "'");
		String course = jdbcTemplate.queryForObject(SQLQueries.COURSE_OF_ATTENDANCE + AUUIDForMysql, String.class);
		String time = jdbcTemplate.queryForObject(SQLQueries.TIME_OF_ATTENDANCE + AUUIDForMysql, String.class);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = dateFormat.format(xmlCalendar.toGregorianCalendar().getTime());
		assertEquals(course, cuuid);
		assertEquals(time, dateStr.toString());
		jdbcTemplate.update(SQLQueries.DELETE_STUDENT + SUUIDForMysql);
		jdbcTemplate.update(SQLQueries.DELETE_ATTENDANCE + AUUIDForMysql);
		jdbcTemplate.update(SQLQueries.DELETE_COURSE + CUUIDForMysql);
	}

	@Test
	public void testFindAttendees() throws DatatypeConfigurationException, WrongInputException_Exception {
		System.out.println("findAttendees");
		String cuuid = port.insertCourse("KOPR");
		String CUUIDForMysql = ("'" + cuuid + "'");
		String suuid1 = port.insertStudent("Dragonslayer", "Ornstein");
		String SUUIDForMysql1 = ("'" + suuid1 + "'");
		String suuid2 = port.insertStudent("Ashen", "One");
		String SUUIDForMysql2 = ("'" + suuid2 + "'");
		List<String> attendees = new ArrayList<>();
		attendees.add(suuid1);
		attendees.add(suuid2);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		String auuid = port.insertAttendance(cuuid, xmlCalendar, attendees);
		String AUUIDForMysql = ("'" + auuid + "'");
		List<String> results = port.findAttendees(auuid);
		assertEquals(attendees.size(), results.size());
		jdbcTemplate.update(SQLQueries.DELETE_STUDENT + SUUIDForMysql1);
		jdbcTemplate.update(SQLQueries.DELETE_STUDENT + SUUIDForMysql2);
		jdbcTemplate.update(SQLQueries.DELETE_ATTENDANCE + AUUIDForMysql);
		jdbcTemplate.update(SQLQueries.DELETE_COURSE + CUUIDForMysql);
	}

	@Test
	public void testFindAttendancesOfAttendee() throws DatatypeConfigurationException, WrongInputException_Exception {
		System.out.println("AttendancesOfAttendee");
		String cuuid = port.insertCourse("KOPR");
		String CUUIDForMysql = ("'" + cuuid + "'");
		String suuid = port.insertStudent("Chosen", "Undead");
		String SUUIDForMysql = ("'" + suuid + "'");
		List<String> attendees = new ArrayList<>();
		attendees.add(suuid);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		String auuid1 = port.insertAttendance(cuuid, xmlCalendar, attendees);
		String auuid2 = port.insertAttendance(cuuid, xmlCalendar, attendees);
		String AUUIDForMysql1 = ("'" + auuid1 + "'");
		String AUUIDForMysql2 = ("'" + auuid2 + "'");
		List<Attendance> results = port.attendancesOfAttendee(suuid);
		assertEquals(results.size(), 2);
		jdbcTemplate.update(SQLQueries.DELETE_STUDENT + SUUIDForMysql);
		jdbcTemplate.update(SQLQueries.DELETE_ATTENDANCE + AUUIDForMysql1);
		jdbcTemplate.update(SQLQueries.DELETE_ATTENDANCE + AUUIDForMysql2);
		jdbcTemplate.update(SQLQueries.DELETE_COURSE + CUUIDForMysql);
	}

	@Test
	public void testInsertAttendanceFailedCourse() throws DatatypeConfigurationException {
		System.out.println("insertAttendanceFailedCourse");
		String suuid = port.insertStudent("Executioner", "Smough");
		String SUUIDForMysql = ("'" + suuid + "'");
		List<String> attendees = new ArrayList<>();
		attendees.add(suuid);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		try {
			port.insertAttendance("21f87078-0b25-11e8-b159-086266b31825", xmlCalendar, attendees);
		} catch (Exception e) {
			assert (e.toString().contains("does not exist"));
		} finally {
			jdbcTemplate.update(SQLQueries.DELETE_STUDENT + SUUIDForMysql);
		}
	}

	@Test
	public void testInsertAttendanceFailedStudent() throws DatatypeConfigurationException {
		System.out.println("insertAttendanceFailedStudent");
		String cuuid = port.insertCourse("KOPR");
		String CUUIDForMysql = ("'" + cuuid + "'");
		List<String> attendees = new ArrayList<>();
		attendees.add("21f87078-0b25-11e8-b159-086266b31825");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		try {
			port.insertAttendance(cuuid, xmlCalendar, attendees);
		} catch (Exception e) {
			assert (e.toString().contains("does not exist"));
			System.out.println(e.toString());
		} finally {
			jdbcTemplate.update(SQLQueries.DELETE_COURSE + CUUIDForMysql);
		}
	}

	@Test
	public void testInsertAttendanceFailedSBoth() throws DatatypeConfigurationException {
		System.out.println("insertAttendanceFailedBoth");
		String cuuid = "291dea46-0b28-11e8-b159-086266b31825";
		List<String> attendees = new ArrayList<>();
		attendees.add("21f87078-0b25-11e8-b159-086266b31825");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(117, 1, 25, 14, 0, 0);
		calendar.clear(Calendar.MILLISECOND);
		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		try {
			port.insertAttendance(cuuid, xmlCalendar, attendees);
		} catch (Exception e) {
			assert (e.toString().contains("does not exist"));
			System.out.println(e.toString());
		}
	}

	@Test
	public void testFindAttendeesFailed() throws DatatypeConfigurationException {
		System.out.println("findAttendeesFailed");
		try {
			port.findAttendees("21f87078-0b25-11e8-b159-086266b31825");
		} catch (Exception e) {
			assert (e.toString().contains("does not exist"));
			System.out.println(e.toString());
		}
	}

	@Test
	public void testFindAttendancesOfAttendeeFailed() throws DatatypeConfigurationException {
		System.out.println("AttendancesOfAttendeeFailed");
		try {
			List<Attendance> results = port.attendancesOfAttendee("21f87078-0b25-11e8-b159-086266b31825");
		} catch (Exception e) {
			assert (e.toString().contains("does not exist"));
			System.out.println(e.toString());
		}
	}

}
