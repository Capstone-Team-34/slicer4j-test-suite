package EmailSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public class EmailClientTest {
    public EmailClientTest() {}

    @Before
    public void resetCounter(){
        Email.emailCounter = 0;
    }

    @Test
    public void createEmail() {
        Client bob = Client.createClient("bob");

        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailFrom().equals(bob));
        assertTrue(msg.getEmailTo().equals("alice") );
        assertTrue(msg.getEmailSubject().equals("Hello"));
        assertTrue(msg.getEmailBody().equals("World"));
    }

    @Test
    public void isReadable() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.isReadable());

        msg.setEmailIsEncrypted(true);

        assertTrue(!msg.isReadable());
    }

    @Test
    public void getEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailFrom().equals(bob));
    }

    @Test
    public void getId() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");
        for(int i = 1; i <= 10; i++) {
            msg = Email.createEmail(bob, "alice", "Hello", "World");
        }
        assertTrue(msg.getId() == 10);

    }

    @Test
    public void getEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailSubject().equals("Hello"));
    }

    @Test
    public void getEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailTo().equals("alice"));
    }

    @Test
    public void setEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailBody().equals("World"));
    }

    @Test
    public void setEmailFrom() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailFrom().equals(bob));

        Client fred = Client.createClient("fred");

        msg.setEmailFrom(fred);

        assertTrue(msg.getEmailFrom().equals(fred));
    }

    @Test
    public void setEmailSubject() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailSubject().equals("Hello"));

        msg.setEmailSubject("foo");

        assertTrue(msg.getEmailSubject().equals("foo"));
    }

    @Test
    public void setEmailTo() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailTo().equals("alice"));

        msg.setEmailTo("fred");

        assertTrue(msg.getEmailTo().equals("fred"));
    }

    @Test
    public void getEmailBody() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(msg.getEmailBody().equals("World"));

        msg.setEmailBody("bar");

        assertTrue(msg.getEmailBody().equals("bar"));
    }

    @Test
    public void isEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assertTrue(msg.isEncrypted());
    }

    @Test
    public void setEmailIsEncrypted() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(!msg.isEncrypted());

        msg.setEmailIsEncrypted(true);

        assertTrue(msg.isEncrypted());
    }

    @Test
    public void setEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assertTrue(msg.getEmailEncryptionKey() == 24);
    }

    @Test
    public void getEmailEncryptionKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailEncryptionKey(24);

        assertTrue(msg.getEmailEncryptionKey() == 24);
    }

    @Test
    public void setEmailIsSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailIsSigned(true);

        assertTrue(msg.isSigned());
    }

    @Test
    public void setEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        msg.setEmailSignKey(26);

        assertTrue(msg.getEmailSignKey() == 26);
    }

    @Test
    public void isSigned() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assertTrue(msg.isSigned());
    }

    @Test
    public void getEmailSignKey() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(!msg.isSigned());

        msg.setEmailIsSigned(true);

        assertTrue(msg.isSigned());
    }

    @Test
    public void isSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assertTrue(msg.isSignatureVerified());
    }

    @Test
    public void setIsSignatureVerified() {
        Client bob = Client.createClient("bob");
        Email msg = Email.createEmail(bob, "alice", "Hello", "World");

        assertTrue(!msg.isSignatureVerified());

        msg.setIsSignatureVerified(true);

        assertTrue(msg.isSignatureVerified());
    }

    @Test
    public void getClientId() {
        Client.clientCounter = 0;
        Email.emailCounter = 0;
        Client c = Client.createClient("bob");

        for(int i = 0; i < 10; i++){
            c = Client.createClient("bob");
        }

        assertTrue(c.id == 10);
    }

    @Test
    public void sendEmail() {
        Client bob = Client.createClient("bob");
        Client alice = Client.createClient("alice");

        //Sending email from bob to alice
        assertTrue(Client.sendEmail(bob, "alice", "Hello", "World") == 0);

        //Sending email from alice to carl
        assertThrows(IllegalArgumentException.class, () -> {
            Client.sendEmail(alice, "carl", "Hello", "World");
        });
    }

    @Test
    public void getName() {
        Client c = Client.createClient("bob");
        assertTrue(c.getName().equals("bob"));
    }

    @Test
    public void createClient() {
        Client.clientCounter = 0;
        Email.emailCounter = 0;
        Client c = Client.createClient("bob");
        assertTrue(c.name.equals("bob"));
        assertTrue(c.id == 0);

        c = Client.createClient("alice");
        assertTrue(c.name.equals("alice"));
        assertTrue(c.id == 1);
    }

    @Test
    public void getClientById() {
        Client.clientCounter = 0;
        Email.emailCounter = 0;
        Client[] c = new Client[100];
        for(int i = 0; i < 100; i++){
            c[i] = Client.createClient(String.valueOf(i));
        }
        for(int i = 0; i < 100; i++){
            assertTrue(Client.getClientById(i).getName().equals(String.valueOf(i)));
        }
    }

    @Test
    public void getClientByAdress() {
        Client.clientCounter = 0;
        Email.emailCounter = 0;
        Client[] c = new Client[100];
        for(int i = 0; i < 100; i++){
            c[i] = Client.createClient(String.valueOf(i));
        }
        for(int i = 0; i < 100; i++){
            assertTrue(Client.getClientByAdress(String.valueOf(i)).getId() == i);
        }
    }

    @Test
    public void resetClients() {
        Client c = Client.createClient("bob");

        for(int i = 0; i < 10; i++){
            c = Client.createClient("bob");
        }

        Client.resetClients();

        for(int j = 0; j < Client.clients.length; j++) {
            assertTrue(Client.clients[j] == null);
        }

        c = Client.createClient("bob");
        assertTrue(c.name.equals("bob"));
        assertTrue(c.id == 0);
    }

    @Test
    public void testToString() {
        Client c =  Client.createClient("bob");

        assertTrue(c.toString().equals("bob"));
    }

    @Test
    public void setPrivateKey() {
        Client c = Client.createClient("bob");
        c.setPrivateKey(12);
        assertTrue(c.getPrivateKey() == 12);
    }

    @Test
    public void getPrivateKey() {
        Client c = Client.createClient("bob");
        c.setPrivateKey(12);
        assertTrue(c.getPrivateKey() == 12);
    }

    @Test
    public void generateKeyPair() {
        Client c = Client.createClient("bob");
        Client.generateKeyPair(c,25);
        assertTrue(c.getPrivateKey() == 25);
    }

    @Test
    public void addKeyringEntry() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");
        Client.KeyringEntry kc;

        for(int i = 0; i < 100; i++) {
            c.addKeyringEntry(b, i);
        }
        for(int i = 0; i < 100; i++) {
            assertTrue (c.keyring.get(i).getPublicKey() == i);
        }
    }

    @Test
    public void getKeyringPublicKeyByClient() {
        Client bob = Client.createClient("bob");
        Client alice = Client.createClient("alice");
        Client fred = Client.createClient("fred");

        bob.addKeyringEntry(alice, 12);
        bob.addKeyringEntry(fred, 16);

        alice.addKeyringEntry(bob,11);
        alice.addKeyringEntry(fred, 32);

        fred.addKeyringEntry(bob, 24);
        fred.addKeyringEntry(alice, 33);

        assertTrue(bob.getKeyringPublicKeyByClient(alice) == 12);
        assertTrue(bob.getKeyringPublicKeyByClient(fred) == 16);

        assertTrue(alice.getKeyringPublicKeyByClient(bob) == 11);
        assertTrue(alice.getKeyringPublicKeyByClient(fred) == 32);

        assertTrue(fred.getKeyringPublicKeyByClient(bob) == 24);
        assertTrue(fred.getKeyringPublicKeyByClient(alice) == 33);

    }

    @Test
    public void isKeyPairValid() {
        assertTrue(Client.isKeyPairValid(12, 12));
        assertTrue(!Client.isKeyPairValid(24, 38));
    }

    @Test
    public void setAutoResponse() {
        Client c = Client.createClient("bob");
        c.setAutoResponse(true);

        assertTrue(c.isAutoResponse());

        c.setAutoResponse(false);

        assertTrue(!c.isAutoResponse());
    }

    @Test
    public void isAutoResponse() {
        Client c = Client.createClient("bob");
        c.setAutoResponse(true);

        assertTrue(c.isAutoResponse());

        c.setAutoResponse(false);

        assertTrue(!c.isAutoResponse());
    }

    @Test
    public void getAddressBookReceiversForAlias() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");

        c.addAddressbookEntry("craig", "alice");
        c.addAddressbookEntry("craig","fred");
        b.addAddressbookEntry("berry", "bob");

        assertTrue(c.getAddressBookReceiversForAlias("craig").get(0).equals("alice"));
        assertTrue(c.getAddressBookReceiversForAlias("craig").get(1).equals("fred"));
        assertTrue(b.getAddressBookReceiversForAlias("berry").get(0).equals("bob"));
    }

    @Test
    public void addAddressbookEntry() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");

        c.addAddressbookEntry("craig", "alice");
        c.addAddressbookEntry("craig","fred");
        b.addAddressbookEntry("berry", "bob");

        assertTrue(c.getAddressBookReceiversForAlias("craig").get(0).equals("alice"));
        assertTrue(c.getAddressBookReceiversForAlias("craig").get(1).equals("fred"));
        assertTrue(b.getAddressBookReceiversForAlias("berry").get(0).equals("bob"));
    }

    @Test
    public void sign() {
        Client c = Client.createClient("bob");

        Email msg = Email.createEmail(c, "alice", "Hello", "World");

        Client.sign(c, msg);

        assertTrue(!msg.isSigned());

        c.setPrivateKey(12);

        Client.sign(c, msg);

        assertTrue(msg.isSigned());
    }

    @Test
    public void setForwardReceiver() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");
        c.setForwardReceiver(b);
        assertTrue(c.getForwardReceiver().equals(b));
    }

    @Test
    public void getForwardReceiver() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");
        c.setForwardReceiver(b);
        assertTrue(c.getForwardReceiver().equals(b));
    }

    @Test
    public void verify() {
        Client c = Client.createClient("bob");

        c.setPrivateKey(12);
        c.addKeyringEntry(c,12);

        Email msg = Email.createEmail(c, "alice", "Hello", "World");

        Client.verify(c, msg);

        assertTrue(!msg.isSignatureVerified());

        msg.setEmailSignKey(12);

        Client.verify(c, msg);

        assertTrue(msg.isSignatureVerified());
    }
}