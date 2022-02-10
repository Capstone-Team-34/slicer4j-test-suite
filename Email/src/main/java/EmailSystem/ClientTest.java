package EmailSystem;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class ClientTest {
    public ClientTest() {}

    @Test
    public void getId() {
        Client c = Client.createClient("bob");

        for(int i = 0; i < 10; i++){
            c = Client.createClient("bob");
        }

        assert(c.id == 10);
    }

    @Test
    public void sendEmail() {
        Client bob = Client.createClient("bob");
        Client alice = Client.createClient("alice");

        //Sending email from bob to alice
        assert(Client.sendEmail(bob, "alice", "Hello", "World") == 0);

        //Sending email from alice to carl
        assertThrows(IllegalArgumentException.class, () -> {
            Client.sendEmail(alice, "carl", "Hello", "World");
        });
    }

    @Test
    public void getName() {
        Client c = Client.createClient("bob");
        assert(c.getName().equals("bob"));
    }

    @Test
    public void createClient() {
        Client c = Client.createClient("bob");
        assert(c.name.equals("bob"));
        assert(c.id == 0);

        c = Client.createClient("alice");
        assert(c.name.equals("alice"));
        assert(c.id == 1);
    }

    @Test
    public void getClientById() {
        Client[] c = new Client[100];
        for(int i = 0; i < 100; i++){
            c[i] = Client.createClient(String.valueOf(i));
        }
        for(int i = 0; i < 100; i++){
            assert(Client.getClientById(i).getName().equals(String.valueOf(i)));
        }
    }

    @Test
    public void getClientByAdress() {
        Client[] c = new Client[100];
        for(int i = 0; i < 100; i++){
            c[i] = Client.createClient(String.valueOf(i));
        }
        for(int i = 0; i < 100; i++){
            assert(Client.getClientByAdress(String.valueOf(i)).getId() == i);
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
            assert (Client.clients[j] == null);
        }

        c = Client.createClient("bob");
        assert(c.name.equals("bob"));
        assert(c.id == 0);
    }

    @Test
    public void testToString() {
        Client c =  Client.createClient("bob");

        assert(c.toString().equals("bob"));
    }

    @Test
    public void setPrivateKey() {
        Client c = Client.createClient("bob");
        c.setPrivateKey(12);
        assert(c.getPrivateKey() == 12);
    }

    @Test
    public void getPrivateKey() {
        Client c = Client.createClient("bob");
        c.setPrivateKey(12);
        assert(c.getPrivateKey() == 12);
    }

    @Test
    public void generateKeyPair() {
        Client c = Client.createClient("bob");
        Client.generateKeyPair(c,25);
        assert(c.getPrivateKey() == 25);
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
            assert (c.keyring.get(i).getPublicKey() == i);
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

        assert(bob.getKeyringPublicKeyByClient(alice) == 12);
        assert(bob.getKeyringPublicKeyByClient(fred) == 16);

        assert(alice.getKeyringPublicKeyByClient(bob) == 11);
        assert(alice.getKeyringPublicKeyByClient(fred) == 32);

        assert(fred.getKeyringPublicKeyByClient(bob) == 24);
        assert(fred.getKeyringPublicKeyByClient(alice) == 33);

    }

    @Test
    public void isKeyPairValid() {
        assert(Client.isKeyPairValid(12, 12));
        assert(!Client.isKeyPairValid(24, 38));
    }

    @Test
    public void setAutoResponse() {
        Client c = Client.createClient("bob");
        c.setAutoResponse(true);

        assert(c.isAutoResponse());

        c.setAutoResponse(false);

        assert(!c.isAutoResponse());
    }

    @Test
    public void isAutoResponse() {
        Client c = Client.createClient("bob");
        c.setAutoResponse(true);

        assert(c.isAutoResponse());

        c.setAutoResponse(false);

        assert(!c.isAutoResponse());
    }

    @Test
    public void getAddressBookReceiversForAlias() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");

        c.addAddressbookEntry("craig", "alice");
        c.addAddressbookEntry("craig","fred");
        b.addAddressbookEntry("berry", "bob");

        assert(c.getAddressBookReceiversForAlias("craig").get(0).equals("alice"));
        assert(c.getAddressBookReceiversForAlias("craig").get(1).equals("fred"));
        assert(b.getAddressBookReceiversForAlias("berry").get(0).equals("bob"));
    }

    @Test
    public void addAddressbookEntry() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");

        c.addAddressbookEntry("craig", "alice");
        c.addAddressbookEntry("craig","fred");
        b.addAddressbookEntry("berry", "bob");

        assert(c.getAddressBookReceiversForAlias("craig").get(0).equals("alice"));
        assert(c.getAddressBookReceiversForAlias("craig").get(1).equals("fred"));
        assert(b.getAddressBookReceiversForAlias("berry").get(0).equals("bob"));
    }

    @Test
    public void sign() {
        Client c = Client.createClient("bob");

        Email msg = Email.createEmail(c, "alice", "Hello", "World");

        Client.sign(c, msg);

        assert(!msg.isSigned());

        c.setPrivateKey(12);

        Client.sign(c, msg);

        assert(msg.isSigned());
    }

    @Test
    public void setForwardReceiver() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");
        c.setForwardReceiver(b);
        assert(c.getForwardReceiver().equals(b));
    }

    @Test
    public void getForwardReceiver() {
        Client c = Client.createClient("bob");
        Client b = Client.createClient("alice");
        c.setForwardReceiver(b);
        assert(c.getForwardReceiver().equals(b));
    }

    @Test
    public void verify() {
        Client c = Client.createClient("bob");

        c.setPrivateKey(12);
        c.addKeyringEntry(c,12);

        Email msg = Email.createEmail(c, "alice", "Hello", "World");

        Client.verify(c, msg);

        assert(!msg.isSignatureVerified());

        msg.setEmailSignKey(12);

        Client.verify(c, msg);

        assert(msg.isSignatureVerified());
    }
}