
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WrongInputException_QNAME = new QName("http://server/", "WrongInputException");
    private final static QName _AttendancesOfAttendee_QNAME = new QName("http://server/", "attendancesOfAttendee");
    private final static QName _InsertAttendanceResponse_QNAME = new QName("http://server/", "insertAttendanceResponse");
    private final static QName _InsertCourse_QNAME = new QName("http://server/", "insertCourse");
    private final static QName _FindAttendees_QNAME = new QName("http://server/", "findAttendees");
    private final static QName _InsertAttendance_QNAME = new QName("http://server/", "insertAttendance");
    private final static QName _AttendancesOfAttendeeResponse_QNAME = new QName("http://server/", "attendancesOfAttendeeResponse");
    private final static QName _InsertCourseResponse_QNAME = new QName("http://server/", "insertCourseResponse");
    private final static QName _InsertStudent_QNAME = new QName("http://server/", "insertStudent");
    private final static QName _FindAttendeesResponse_QNAME = new QName("http://server/", "findAttendeesResponse");
    private final static QName _InsertStudentResponse_QNAME = new QName("http://server/", "insertStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAttendeesResponse }
     * 
     */
    public FindAttendeesResponse createFindAttendeesResponse() {
        return new FindAttendeesResponse();
    }

    /**
     * Create an instance of {@link InsertStudentResponse }
     * 
     */
    public InsertStudentResponse createInsertStudentResponse() {
        return new InsertStudentResponse();
    }

    /**
     * Create an instance of {@link AttendancesOfAttendeeResponse }
     * 
     */
    public AttendancesOfAttendeeResponse createAttendancesOfAttendeeResponse() {
        return new AttendancesOfAttendeeResponse();
    }

    /**
     * Create an instance of {@link InsertCourseResponse }
     * 
     */
    public InsertCourseResponse createInsertCourseResponse() {
        return new InsertCourseResponse();
    }

    /**
     * Create an instance of {@link InsertStudent }
     * 
     */
    public InsertStudent createInsertStudent() {
        return new InsertStudent();
    }

    /**
     * Create an instance of {@link InsertAttendance }
     * 
     */
    public InsertAttendance createInsertAttendance() {
        return new InsertAttendance();
    }

    /**
     * Create an instance of {@link FindAttendees }
     * 
     */
    public FindAttendees createFindAttendees() {
        return new FindAttendees();
    }

    /**
     * Create an instance of {@link InsertAttendanceResponse }
     * 
     */
    public InsertAttendanceResponse createInsertAttendanceResponse() {
        return new InsertAttendanceResponse();
    }

    /**
     * Create an instance of {@link InsertCourse }
     * 
     */
    public InsertCourse createInsertCourse() {
        return new InsertCourse();
    }

    /**
     * Create an instance of {@link WrongInputException }
     * 
     */
    public WrongInputException createWrongInputException() {
        return new WrongInputException();
    }

    /**
     * Create an instance of {@link AttendancesOfAttendee }
     * 
     */
    public AttendancesOfAttendee createAttendancesOfAttendee() {
        return new AttendancesOfAttendee();
    }

    /**
     * Create an instance of {@link Attendance }
     * 
     */
    public Attendance createAttendance() {
        return new Attendance();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WrongInputException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "WrongInputException")
    public JAXBElement<WrongInputException> createWrongInputException(WrongInputException value) {
        return new JAXBElement<WrongInputException>(_WrongInputException_QNAME, WrongInputException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttendancesOfAttendee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "attendancesOfAttendee")
    public JAXBElement<AttendancesOfAttendee> createAttendancesOfAttendee(AttendancesOfAttendee value) {
        return new JAXBElement<AttendancesOfAttendee>(_AttendancesOfAttendee_QNAME, AttendancesOfAttendee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertAttendanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "insertAttendanceResponse")
    public JAXBElement<InsertAttendanceResponse> createInsertAttendanceResponse(InsertAttendanceResponse value) {
        return new JAXBElement<InsertAttendanceResponse>(_InsertAttendanceResponse_QNAME, InsertAttendanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "insertCourse")
    public JAXBElement<InsertCourse> createInsertCourse(InsertCourse value) {
        return new JAXBElement<InsertCourse>(_InsertCourse_QNAME, InsertCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAttendees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findAttendees")
    public JAXBElement<FindAttendees> createFindAttendees(FindAttendees value) {
        return new JAXBElement<FindAttendees>(_FindAttendees_QNAME, FindAttendees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertAttendance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "insertAttendance")
    public JAXBElement<InsertAttendance> createInsertAttendance(InsertAttendance value) {
        return new JAXBElement<InsertAttendance>(_InsertAttendance_QNAME, InsertAttendance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttendancesOfAttendeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "attendancesOfAttendeeResponse")
    public JAXBElement<AttendancesOfAttendeeResponse> createAttendancesOfAttendeeResponse(AttendancesOfAttendeeResponse value) {
        return new JAXBElement<AttendancesOfAttendeeResponse>(_AttendancesOfAttendeeResponse_QNAME, AttendancesOfAttendeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "insertCourseResponse")
    public JAXBElement<InsertCourseResponse> createInsertCourseResponse(InsertCourseResponse value) {
        return new JAXBElement<InsertCourseResponse>(_InsertCourseResponse_QNAME, InsertCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "insertStudent")
    public JAXBElement<InsertStudent> createInsertStudent(InsertStudent value) {
        return new JAXBElement<InsertStudent>(_InsertStudent_QNAME, InsertStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAttendeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "findAttendeesResponse")
    public JAXBElement<FindAttendeesResponse> createFindAttendeesResponse(FindAttendeesResponse value) {
        return new JAXBElement<FindAttendeesResponse>(_FindAttendeesResponse_QNAME, FindAttendeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "insertStudentResponse")
    public JAXBElement<InsertStudentResponse> createInsertStudentResponse(InsertStudentResponse value) {
        return new JAXBElement<InsertStudentResponse>(_InsertStudentResponse_QNAME, InsertStudentResponse.class, null, value);
    }

}
