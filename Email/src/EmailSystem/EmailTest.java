package EmailSystem;

import tests.TestCommand;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @org.junit.jupiter.api.Test
    void createEmail() {
        Client bob = Client.createClient("bob");

        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        
        assert(msg.getEmailFrom().equals(bob));
        assert(msg.getEmailTo().equals("alice") );
        assert(msg.getEmailSubject().equals("Hello"));
        assert(msg.getEmailBody().equals("World"));
    }

    @org.junit.jupiter.api.Test
    void isReadable() {
        TestCommand tc = new TestCommand();
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.isReadable());

        msg.setEmailIsEncrypted(true);

        tc.ENCRYPT___ = true;

        assert(!msg.isReadable());
    }

    @org.junit.jupiter.api.Test
    void printMail() {

    }

    @org.junit.jupiter.api.Test
    void getEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailFrom().equals(bob));
    }

    @org.junit.jupiter.api.Test
    void getId() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        for(int i = 1; i < 10; i++) {
            msg = Email.createEmail(bob, "alice", "Hello", "World");
        }

        assert(msg.getId() == 10);

    }

    @org.junit.jupiter.api.Test
    void getEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailSubject().equals("Hello"));
    }

    @org.junit.jupiter.api.Test
    void getEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailTo().equals("alice"));
    }

    @org.junit.jupiter.api.Test
    void setEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailBody().equals("World"));
    }

    @org.junit.jupiter.api.Test
    void setEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailFrom().equals(bob));

        Client fred = Client.createClient("fred");

        msg.setEmailFrom(fred);

        assert(msg.getEmailFrom().equals(fred));
    }

    @org.junit.jupiter.api.Test
    void setEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailSubject().equals("Hello"));

        msg.setEmailSubject("foo");

        assert(msg.getEmailSubject().equals("foo"));
    }

    @org.junit.jupiter.api.Test
    void setEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailTo().equals("alice"));

        msg.setEmailTo("fred");

        assert(msg.getEmailTo().equals("fred"));
    }

    @org.junit.jupiter.api.Test
    void getEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(msg.getEmailBody().equals("World"));

        msg.setEmailBody("bar");

        assert(msg.getEmailBody().equals("bar"));
    }

    @org.junit.jupiter.api.Test
    void isEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assert(msg.isEncrypted());
    }

    @org.junit.jupiter.api.Test
    void setEmailIsEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assert(msg.isEncrypted());
    }

    @org.junit.jupiter.api.Test
    void setEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assert(msg.getEmailEncryptionKey() == 24);
    }

    @org.junit.jupiter.api.Test
    void getEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assert(msg.getEmailEncryptionKey() == 24);
    }

    @org.junit.jupiter.api.Test
    void setEmailIsSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @org.junit.jupiter.api.Test
    void setEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailSignKey(26);

        assert(msg.getEmailSignKey() == 26);
    }

    @org.junit.jupiter.api.Test
    void isSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @org.junit.jupiter.api.Test
    void getEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assert(msg.isSigned());
    }

    @org.junit.jupiter.api.Test
    void isSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assert(msg.isSignatureVerified());
    }

    @org.junit.jupiter.api.Test
    void setIsSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assert(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assert(msg.isSignatureVerified());
    }
}