package EmailSystem;

import org.junit.Test;

public class EmailTest {
    public EmailTest() {}

    @Test
    public void createEmail() {
        Client bob = Client.createClient("bob");

        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        
        assert(msg.getEmailFrom().equals(bob));
        assert(msg.getEmailTo().equals("alice") );
        assert(msg.getEmailSubject().equals("Hello"));
        assert(msg.getEmailBody().equals("World"));
    }

    @Test
    public void isReadable() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.isReadable());

        msg.setEmailIsEncrypted(true);

        assert(!msg.isReadable());
    }

    @Test
    public void printMail() {

    }

    @Test
    public void getEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailFrom().equals(bob));
    }

    @Test
    public void getId() {
        Email.emailCounter = 0;
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        for(int i = 1; i <= 10; i++) {
            msg = Email.createEmail(bob, "alice", "Hello", "World");
        }

        assert(msg.getId() == 10);

    }

    @Test
    public void getEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailSubject().equals("Hello"));
    }

    @Test
    public void getEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailTo().equals("alice"));
    }

    @Test
    public void setEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailBody().equals("World"));
    }

    @Test
    public void setEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailFrom().equals(bob));

        Client fred = Client.createClient("fred");

        msg.setEmailFrom(fred);

        assert(msg.getEmailFrom().equals(fred));
    }

    @Test
    public void setEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailSubject().equals("Hello"));

        msg.setEmailSubject("foo");

        assert(msg.getEmailSubject().equals("foo"));
    }

    @Test
    public void setEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailTo().equals("alice"));

        msg.setEmailTo("fred");

        assert(msg.getEmailTo().equals("fred"));
    }

    @Test
    public void getEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailBody().equals("World"));

        msg.setEmailBody("bar");

        assert(msg.getEmailBody().equals("bar"));
    }

    @Test
    public void isEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assert(msg.isEncrypted());
    }

    @Test
    public void setEmailIsEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assert(msg.isEncrypted());
    }

    @Test
    public void setEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assert(msg.getEmailEncryptionKey() == 24);
    }

    @Test
    public void getEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assert(msg.getEmailEncryptionKey() == 24);
    }

    @Test
    public void setEmailIsSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @Test
    public void setEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailSignKey(26);

        assert(msg.getEmailSignKey() == 26);
    }

    @Test
    public void isSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @Test
    public void getEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @Test
    public void isSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assert(msg.isSignatureVerified());
    }

    @Test
    public void setIsSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assert(msg.isSignatureVerified());
    }
}