
package client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DefaultAJSService", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DefaultAJSService {


    /**
     * 
     * @param uuid
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws WrongInputException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAttendees", targetNamespace = "http://server/", className = "client.FindAttendees")
    @ResponseWrapper(localName = "findAttendeesResponse", targetNamespace = "http://server/", className = "client.FindAttendeesResponse")
    @Action(input = "http://server/DefaultAJSService/findAttendeesRequest", output = "http://server/DefaultAJSService/findAttendeesResponse", fault = {
        @FaultAction(className = WrongInputException_Exception.class, value = "http://server/DefaultAJSService/findAttendees/Fault/WrongInputException")
    })
    public List<String> findAttendees(
        @WebParam(name = "uuid", targetNamespace = "")
        String uuid)
        throws WrongInputException_Exception
    ;

    /**
     * 
     * @param surname
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertStudent", targetNamespace = "http://server/", className = "client.InsertStudent")
    @ResponseWrapper(localName = "insertStudentResponse", targetNamespace = "http://server/", className = "client.InsertStudentResponse")
    @Action(input = "http://server/DefaultAJSService/insertStudentRequest", output = "http://server/DefaultAJSService/insertStudentResponse")
    public String insertStudent(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "surname", targetNamespace = "")
        String surname);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertCourse", targetNamespace = "http://server/", className = "client.InsertCourse")
    @ResponseWrapper(localName = "insertCourseResponse", targetNamespace = "http://server/", className = "client.InsertCourseResponse")
    @Action(input = "http://server/DefaultAJSService/insertCourseRequest", output = "http://server/DefaultAJSService/insertCourseResponse")
    public String insertCourse(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param courseUUID
     * @param attendees
     * @param time
     * @return
     *     returns java.lang.String
     * @throws WrongInputException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertAttendance", targetNamespace = "http://server/", className = "client.InsertAttendance")
    @ResponseWrapper(localName = "insertAttendanceResponse", targetNamespace = "http://server/", className = "client.InsertAttendanceResponse")
    @Action(input = "http://server/DefaultAJSService/insertAttendanceRequest", output = "http://server/DefaultAJSService/insertAttendanceResponse", fault = {
        @FaultAction(className = WrongInputException_Exception.class, value = "http://server/DefaultAJSService/insertAttendance/Fault/WrongInputException")
    })
    public String insertAttendance(
        @WebParam(name = "courseUUID", targetNamespace = "")
        String courseUUID,
        @WebParam(name = "time", targetNamespace = "")
        XMLGregorianCalendar time,
        @WebParam(name = "attendees", targetNamespace = "")
        List<String> attendees)
        throws WrongInputException_Exception
    ;

    /**
     * 
     * @param uuid
     * @return
     *     returns java.util.List<client.Attendance>
     * @throws WrongInputException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "attendancesOfAttendee", targetNamespace = "http://server/", className = "client.AttendancesOfAttendee")
    @ResponseWrapper(localName = "attendancesOfAttendeeResponse", targetNamespace = "http://server/", className = "client.AttendancesOfAttendeeResponse")
    @Action(input = "http://server/DefaultAJSService/attendancesOfAttendeeRequest", output = "http://server/DefaultAJSService/attendancesOfAttendeeResponse", fault = {
        @FaultAction(className = WrongInputException_Exception.class, value = "http://server/DefaultAJSService/attendancesOfAttendee/Fault/WrongInputException")
    })
    public List<Attendance> attendancesOfAttendee(
        @WebParam(name = "uuid", targetNamespace = "")
        String uuid)
        throws WrongInputException_Exception
    ;

}