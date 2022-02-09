package EmailSystem;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    public void incoming() {
    }

    @Test
    public void outgoing() {
    }

    @Test
    public void sendEmail() {
        Client bob = Client.createClient("bob");
        Client alice = Client.createClient("alice");
        assert(Client.sendEmail(bob, "alice", "Hello", "World") == 0);

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
    }

    @Test
    public void getPrivateKey() {
    }

    @Test
    public void generateKeyPair() {
    }

    @Test
    public void addKeyringEntry() {
    }

    @Test
    public void getKeyringPublicKeyByClient() {
    }

    @Test
    public void isKeyPairValid() {
    }

    @Test
    public void setAutoResponse() {
    }

    @Test
    public void isAutoResponse() {
    }

    @Test
    public void autoRespond() {
    }

    @Test
    public void getAddressBookReceiversForAlias() {
    }

    @Test
    public void addAddressbookEntry() {
    }

    @Test
    public void sign() {
    }

    @Test
    public void setForwardReceiver() {
    }

    @Test
    public void getForwardReceiver() {
    }

    @Test
    public void forward() {
    }

    @Test
    public void verify() {
    }
}