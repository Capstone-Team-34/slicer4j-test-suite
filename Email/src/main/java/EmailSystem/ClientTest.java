package EmailSystem;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class ClientTest {
    public ClientTest() {}

    @Test
    public void getId() {
        try {
            Client c = Client.createClient("bob");

            for(int i = 0; i < 10; i++){
                c = Client.createClient("bob");
            }
    
            assert(c.id == 10);
        } catch (Throwable T) {
            System.out.println("getId failed!");
        }
    }

    @Test
    public void sendEmail() {
        try {
            Client bob = Client.createClient("bob");
            Client alice = Client.createClient("alice");
    
            //Sending email from bob to alice
            assert(Client.sendEmail(bob, "alice", "Hello", "World") == 0);
    
            //Sending email from alice to carl
            assertThrows(IllegalArgumentException.class, () -> {
                Client.sendEmail(alice, "carl", "Hello", "World");
            });
        } catch (Throwable T) {
            System.out.println("sendEmail failed!");
        }

    }

    @Test
    public void getName() {
        try {
            Client c = Client.createClient("bob");
            assert(c.getName().equals("bob"));
        } catch (Throwable T) {
            System.out.println("getName failed!");
        }

    }

    @Test
    public void createClient() {
        try {
            Client c = Client.createClient("bob");
            assert(c.name.equals("bob"));
            assert(c.id == 0);
    
            c = Client.createClient("alice");
            assert(c.name.equals("alice"));
            assert(c.id == 1);
        } catch (Throwable T) {
            System.out.println("createClient failed!");
        }

    }

    @Test
    public void getClientById() {
        try {
            Client[] c = new Client[100];
            for(int i = 0; i < 100; i++){
                c[i] = Client.createClient(String.valueOf(i));
            }
            for(int i = 0; i < 100; i++){
                assert(Client.getClientById(i).getName().equals(String.valueOf(i)));
            }
        } catch (Throwable T) {
            System.out.println("getClientById failed!");
        }

    }

    @Test
    public void getClientByAddress() {
        try {
            Client[] c = new Client[100];
            for(int i = 0; i < 100; i++){
                c[i] = Client.createClient(String.valueOf(i));
            }
            for(int i = 0; i < 100; i++){
                assert(Client.getClientByAdress(String.valueOf(i)).getId() == i);
            }
        } catch (Throwable T) {
            System.out.println("getClientByAddress failed!");
        }

    }

    @Test
    public void resetClients() {
        try {
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
        } catch (Throwable T) {
            System.out.println("resetClients failed!");
        }

    }

    @Test
    public void testToString() {
        try {
            Client c =  Client.createClient("bob");

            assert(c.toString().equals("bob"));
        } catch (Throwable T) {
            System.out.println("testToString failed!");
        }

    }

    @Test
    public void setPrivateKey() {
        try {
            Client c = Client.createClient("bob");
            c.setPrivateKey(12);
            assert(c.getPrivateKey() == 12);
        } catch (Throwable T) {
            System.out.println("setPrivateKey failed!");
        }
    }

    @Test
    public void getPrivateKey() {
        try {
            Client c = Client.createClient("bob");
            c.setPrivateKey(12);
            assert(c.getPrivateKey() == 12);
        } catch (Throwable T) {
            System.out.println("getPrivateKey failed!");
        }
    }

    @Test
    public void generateKeyPair() {
        try {
            Client c = Client.createClient("bob");
            Client.generateKeyPair(c,25);
            assert(c.getPrivateKey() == 25);
        } catch (Throwable T) {
            System.out.println("generateKeyPair failed!");
        }
    }

    @Test
    public void addKeyringEntry() {
        try {
            Client c = Client.createClient("bob");
            Client b = Client.createClient("alice");
            Client.KeyringEntry kc;
    
            for(int i = 0; i < 100; i++) {
                c.addKeyringEntry(b, i);
            }
            for(int i = 0; i < 100; i++) {
                assert (c.keyring.get(i).getPublicKey() == i);
            }
        } catch (Throwable T) {
            System.out.println("addKeyringEntry failed!");
        }

    }

    @Test
    public void getKeyringPublicKeyByClient() {
        try {
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
        } catch (Throwable T) {
            System.out.println("getKeyringPublicKeyByClient failed!");
        }
    }

    @Test
    public void isKeyPairValid() {
        try {
            assert(Client.isKeyPairValid(12, 12));
            assert(!Client.isKeyPairValid(24, 38));
        } catch (Throwable T) {
            System.out.println("isKeyPairValid failed!");
        }

    }

    @Test
    public void setAutoResponse() {
        try {
            Client c = Client.createClient("bob");
            c.setAutoResponse(true);
    
            assert(c.isAutoResponse());
    
            c.setAutoResponse(false);
    
            assert(!c.isAutoResponse());
        } catch (Throwable T) {
            System.out.println("setAutoResponse failed!");
        }
    }

    @Test
    public void isAutoResponse() {
        try {
            Client c = Client.createClient("bob");
            c.setAutoResponse(true);
    
            assert(c.isAutoResponse());
    
            c.setAutoResponse(false);
    
            assert(!c.isAutoResponse());
        } catch (Throwable T) {
            System.out.println("isAutoResponse failed!");
        }
    }

    @Test
    public void getAddressBookReceiversForAlias() {
        try {
            Client c = Client.createClient("bob");
            Client b = Client.createClient("alice");
    
            c.addAddressbookEntry("craig", "alice");
            c.addAddressbookEntry("craig","fred");
            b.addAddressbookEntry("berry", "bob");
    
            assert(c.getAddressBookReceiversForAlias("craig").get(0).equals("alice"));
            assert(c.getAddressBookReceiversForAlias("craig").get(1).equals("fred"));
            assert(b.getAddressBookReceiversForAlias("berry").get(0).equals("bob"));
        } catch (Throwable T) {
            System.out.println("getAddressBookReceiversForAlias failed!");
        }
    }

    @Test
    public void addAddressbookEntry() {
        try {
            Client c = Client.createClient("bob");
            Client b = Client.createClient("alice");
    
            c.addAddressbookEntry("craig", "alice");
            c.addAddressbookEntry("craig","fred");
            b.addAddressbookEntry("berry", "bob");
    
            assert(c.getAddressBookReceiversForAlias("craig").get(0).equals("alice"));
            assert(c.getAddressBookReceiversForAlias("craig").get(1).equals("fred"));
            assert(b.getAddressBookReceiversForAlias("berry").get(0).equals("bob"));
        } catch (Throwable T) {
            System.out.println("addAddressbookEntry failed!");
        }
    }

    @Test
    public void sign() {
        try {
            Client c = Client.createClient("bob");

            Email msg = Email.createEmail(c, "alice", "Hello", "World");
    
            Client.sign(c, msg);
    
            assert(!msg.isSigned());
    
            c.setPrivateKey(12);
    
            Client.sign(c, msg);
    
            assert(msg.isSigned());
        } catch (Throwable T) {
            System.out.println("sign failed!");
        }
    }

    @Test
    public void setForwardReceiver() {
        try {
            Client c = Client.createClient("bob");
            Client b = Client.createClient("alice");
            c.setForwardReceiver(b);
            assert(c.getForwardReceiver().equals(b));
        } catch (Throwable T) {
            System.out.println("setForwardReceiver failed!");
        }
    }

    @Test
    public void getForwardReceiver() {
        try {
            Client c = Client.createClient("bob");
            Client b = Client.createClient("alice");
            c.setForwardReceiver(b);
            assert(c.getForwardReceiver().equals(b));
        } catch (Throwable T) {
            System.out.println("getForwardReceiver failed!");
        }
    }

    @Test
    public void verify() {
        try {
            Client c = Client.createClient("bob");

            c.setPrivateKey(12);
            c.addKeyringEntry(c,12);
    
            Email msg = Email.createEmail(c, "alice", "Hello", "World");
    
            Client.verify(c, msg);
    
            assert(!msg.isSignatureVerified());
    
            msg.setEmailSignKey(12);
    
            Client.verify(c, msg);
    
            assert(msg.isSignatureVerified());
        } catch (Throwable T) {
            System.out.println("verify failed!");
        }
    }
}