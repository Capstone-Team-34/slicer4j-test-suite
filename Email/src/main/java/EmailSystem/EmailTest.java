package EmailSystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class EmailTest {
    public EmailTest() {}

    @Before
    public void resestCounter(){
        Email.emailCounter = 0;
    }

    @Test
    public void createEmail() {
        try {
            Client bob = Client.createClient("bob");

            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
            
            assertTrue(msg.getEmailFrom().equals(bob));
            assertTrue(msg.getEmailTo().equals("alice") );
            assertTrue(msg.getEmailSubject().equals("Hello"));
            assertTrue(msg.getEmailBody().equals("World"));
        } catch (Throwable T) {
            System.out.println("createEmail failed!");
        }
    }

    @Test
    public void isReadable() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.isReadable());
    
            msg.setEmailIsEncrypted(true);
    
            assertTrue(!msg.isReadable());
        } catch (Throwable T) {
            System.out.println("isReadable failed");
        }
    }

    @Test
    public void getEmailFrom() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailFrom().equals(bob));
        } catch (Throwable T) {
            System.out.println("getEmailFrom failed!");
        }
    }

    @Test
    public void getId() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
            for(int i = 1; i <= 10; i++) {
                msg = Email.createEmail(bob, "alice", "Hello", "World");
            }
            assertTrue(msg.getId() == 10);
        } catch (Throwable T) {
            System.out.println("getId failed!");
        }
    }

    @Test
    public void getEmailSubject() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailSubject().equals("Hello"));
        } catch (Throwable T) {
            System.out.println("getEmailSubject failed!");
        }
    }

    @Test
    public void getEmailTo() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailTo().equals("alice"));
        } catch (Throwable T) {
            System.out.println("getEmailTo failed!");
        }

    }

    @Test
    public void setEmailBody() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailBody().equals("World"));
        } catch (Throwable T) {
            System.out.println("setEmailBody failed!");
        }
    }

    @Test
    public void setEmailFrom() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailFrom().equals(bob));
    
            Client fred = Client.createClient("fred");
    
            msg.setEmailFrom(fred);
    
            assertTrue(msg.getEmailFrom().equals(fred));
        } catch (Throwable T) {
            System.out.println("setEmailFrom failed!");
        }

    }

    @Test
    public void setEmailSubject() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailSubject().equals("Hello"));
    
            msg.setEmailSubject("foo");
    
            assertTrue(msg.getEmailSubject().equals("foo"));
        } catch (Throwable T) {
            System.out.println("setEmailSubject failed!");
        }

    }

    @Test
    public void setEmailTo() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailTo().equals("alice"));
    
            msg.setEmailTo("fred");
    
            assertTrue(msg.getEmailTo().equals("fred"));
        } catch (Throwable T) {
            System.out.println("setEmailTo failed!");
        }
    }

    @Test
    public void getEmailBody() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(msg.getEmailBody().equals("World"));
    
            msg.setEmailBody("bar");
    
            assertTrue(msg.getEmailBody().equals("bar"));
        } catch (Throwable T) {
            System.out.println("getEmailBody failed!");
        }
    }

    @Test
    public void isEncrypted() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(!msg.isEncrypted());
    
            msg.setEmailIsEncrypted(true);
    
            assertTrue(msg.isEncrypted());
        } catch (Throwable T) {
            System.out.println("isEncrypted failed!");
        }

    }

    @Test
    public void setEmailIsEncrypted() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(!msg.isEncrypted());
    
            msg.setEmailIsEncrypted(true);
    
            assertTrue(msg.isEncrypted());
        } catch (Throwable T) {
            System.out.println("setEmailIsEncrypted failed!");
        }

    }

    @Test
    public void setEmailEncryptionKey() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            msg.setEmailEncryptionKey(24);
    
            assertTrue(msg.getEmailEncryptionKey() == 24);
        } catch (Throwable T) {
            System.out.println("setEmailEncryptionKey failed!");
        }

    }

    @Test
    public void getEmailEncryptionKey() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            msg.setEmailEncryptionKey(24);
    
            assertTrue(msg.getEmailEncryptionKey() == 24);
        } catch (Throwable T) {
            System.out.println("getEmailEncryptionKey failed!");
        }
    }

    @Test
    public void setEmailIsSigned() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            msg.setEmailIsSigned(true);
    
            assertTrue(msg.isSigned());
        } catch (Throwable T) {
            System.out.println("setEmailIsSigned failed!");
        }
    }

    @Test
    public void setEmailSignKey() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            msg.setEmailSignKey(26);
    
            assertTrue(msg.getEmailSignKey() == 26);
        } catch (Throwable T) {
            System.out.println("setEmailSignKey failed!");
        }
    }

    @Test
    public void isSigned() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(!msg.isSigned());
    
            msg.setEmailIsSigned(true);
    
            assertTrue(msg.isSigned());
        } catch (Throwable T) {
            System.out.println("isSigned failed!");
        }

    }

    @Test
    public void getEmailSignKey() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(!msg.isSigned());
    
            msg.setEmailIsSigned(true);
    
            assertTrue(msg.isSigned());
        } catch (Throwable T) {
            System.out.println("getEmailSignKey failed!");
        }

    }

    @Test
    public void isSignatureVerified() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(!msg.isSignatureVerified());
    
            msg.setIsSignatureVerified(true);
    
            assertTrue(msg.isSignatureVerified());
        } catch (Throwable T) {
            System.out.println("isSignatureVerified failed!");
        }

    }

    @Test
    public void setIsSignatureVerified() {
        try {
            Client bob = Client.createClient("bob");
            Email msg = Email.createEmail(bob, "alice", "Hello", "World");
    
            assertTrue(!msg.isSignatureVerified());
    
            msg.setIsSignatureVerified(true);
    
            assertTrue(msg.isSignatureVerified());
        } catch (Throwable T) {
            System.out.println("setIsSignatureVerified failed!");
        }

    }
}