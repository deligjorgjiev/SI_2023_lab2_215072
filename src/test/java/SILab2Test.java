import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryBranch() {
        testA();
        testB();
        testC();
        testD();
    }

    @Test
    void testMC() {
        testA();
        assertThrows(RuntimeException.class, () -> SILab2.function(
                new User("username123", null, "hristijan@mail.com"), null));
        assertThrows(RuntimeException.class, () -> SILab2.function(
                new User("username123", "p@ssword!", null), null));

        List<User> allUsers = new ArrayList<>(1);
        allUsers.add(new User("username123", "password.", "hristijan@mail.com"));
        assertDoesNotThrow(() -> SILab2.function(
                new User("username123", "p@ssword!", "hristijan@mail.com"), allUsers)); //nullPointerException if used null instead of allUsers list
    }

    void testA(){
        assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
    }

    void testB(){
        User user = new User(null, "p@ssword!", "hristijan@mail.com");
        List<User> allUsers = new ArrayList<>(1);
        allUsers.add(new User("username123", "password.", "hristijan@mail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    void testC(){
        User user = new User(null, "passw ordd", "hristijan@mail.com");
        List<User> allUsers = new ArrayList<>(2);
        allUsers.add(new User("username123", "password.", "KRistijan@mail.com"));
        allUsers.add(new User("hristijan@mail.com", "password.", "hristijan@mail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    void testD(){
        User user = new User("deligjorgjiev", "deli", "hristijan at mail dot com");
        assertFalse(SILab2.function(user, null)); //null list is okay, because of the email, the list elements are not checked through
    }
}