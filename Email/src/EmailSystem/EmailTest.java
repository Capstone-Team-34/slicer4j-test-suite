package EmailSystem;

import tests.TestCommand;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void createEmail() {
        Client bob = Client.createClient("bob");

        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        
        assert(msg.getEmailFrom().equals(bob));
        assert(msg.getEmailTo().equals("alice") );
        assert(msg.getEmailSubject().equals("Hello"));
        assert(msg.getEmailBody().equals("World"));
    }

    @Test
    void isReadable() {
        TestCommand tc = new TestCommand();
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.isReadable());

        msg.setEmailIsEncrypted(true);

        assert(!msg.isReadable());
    }

    @Test
    void printMail() {

    }

    @Test
    void getEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailFrom().equals(bob));
    }

    @Test
    void getId() {
        Email.emailCounter = 0;
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        for(int i = 1; i <= 10; i++) {
            msg = Email.createEmail(bob, "alice", "Hello", "World");
        }

        assert(msg.getId() == 10);

    }

    @Test
    void getEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailSubject().equals("Hello"));
    }

    @Test
    void getEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailTo().equals("alice"));
    }

    @Test
    void setEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailBody().equals("World"));
    }

    @Test
    void setEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailFrom().equals(bob));

        Client fred = Client.createClient("fred");

        msg.setEmailFrom(fred);

        assert(msg.getEmailFrom().equals(fred));
    }

    @Test
    void setEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailSubject().equals("Hello"));

        msg.setEmailSubject("foo");

        assert(msg.getEmailSubject().equals("foo"));
    }

    @Test
    void setEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailTo().equals("alice"));

        msg.setEmailTo("fred");

        assert(msg.getEmailTo().equals("fred"));
    }

    @Test
    void getEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailBody().equals("World"));

        msg.setEmailBody("bar");

        assert(msg.getEmailBody().equals("bar"));
    }

    @Test
    void isEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assert(msg.isEncrypted());
    }

    @Test
    void setEmailIsEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assert(msg.isEncrypted());
    }

    @Test
    void setEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assert(msg.getEmailEncryptionKey() == 24);
    }

    @Test
    void getEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assert(msg.getEmailEncryptionKey() == 24);
    }

    @Test
    void setEmailIsSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @Test
    void setEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailSignKey(26);

        assert(msg.getEmailSignKey() == 26);
    }

    @Test
    void isSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @Test
    void getEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @Test
    void isSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assert(msg.isSignatureVerified());
    }

    @Test
    void setIsSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assert(msg.isSignatureVerified());
    }
}