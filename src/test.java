import BE.Event;
import BE.GuestTicket;
import BE.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class test {


    @Test
    public void testEventGetName(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        String actual = testEvent.getEventName();
        String expected = "test";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEventGetDate(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        String actual = testEvent.getEventDate();
        String expected = "20-20-2022";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEventGetLocation(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        String actual = testEvent.getEventLocation();
        String expected = "Esbjerg";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEventGetInfo(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        String actual = testEvent.getEventInfo();
        String expected = "Will this work";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEventGetStartTime(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        String actual = testEvent.getStartTime();
        String expected = "12:00";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEventGetEndTime(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        String actual = testEvent.getEndTime();
        String expected = "14:00";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEventGetID(){
        Event testEvent = new Event(68, "test", "20-20-2022", "Esbjerg", "Will this work", "12:00", "14:00");
        int actual = testEvent.getId();
        int expected = 68;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testUserUsername(){
        User test = new User(69, "test", "123", "email@email.com");
        String actual = test.getUsername();
        String expected = "test";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testUserPassword(){
        User test = new User(69, "test", "123", "email@email.com");
        String actual = test.getPassword();
        String expected = "123";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testUserEmail(){
        User test = new User(69, "test", "123", "email@email.com");
        String actual = test.getEmail();
        String expected = "email@email.com";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testUserID(){
        User test = new User(69, "test", "123", "email@email.com");
        int actual = test.getId();
        int expected = 69;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketID(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        int actual = test.getId();
        int expected = 69;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketFirstName(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        String actual = test.getFName();
        String expected = "Jeff";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketLastName(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        String actual = test.getLName();
        String expected = "Bexis";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketMobileNumber(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        String actual = test.getMNumber();
        String expected = "11111111";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketEmail(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        String actual = test.getEmail();
        String expected = "email@email.com";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketChildAmount(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        int actual = test.getChildAmount();
        int expected = 1000;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testGuestTicketAdultAmount(){
        GuestTicket test = new GuestTicket(69, "Jeff", "Bexis", "11111111", "email@email.com", 49, 1000);
        int actual = test.getAdultAmount();
        int expected = 49;
        Assertions.assertEquals(expected, actual);
    }
}
