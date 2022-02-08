package EmailSystem;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getId() {
        Client c = Client.createClient("bob");

        for(int i = 0; i < 10; i++){
            c = Client.createClient("bob");
        }

        assert(c.id == 10);
    }

    @Test
    void incoming() {
    }

    @Test
    void outgoing() {
    }

    @Test
    void sendEmail() {
    }

    @Test
    void getName() {
        Client c = Client.createClient("bob");
        assert(c.getName().equals("bob"));
    }

    @Test
    void createClient() {
        Client c = Client.createClient("bob");
        assert(c.name.equals("bob"));
        assert(c.id == 0);

        c = Client.createClient("alice");
        assert(c.name.equals("alice"));
        assert(c.id == 1);
    }

    @Test
    void getClientById() {
        Client[] c = new Client[100];
        for(int i = 0; i < 100; i++){
            c[i] = Client.createClient(String.valueOf(i));
        }
        for(int i = 0; i < 100; i++){
            assert(Client.getClientById(i).getName().equals(String.valueOf(i)));
        }
    }

    @Test
    void getClientByAdress() {
        Client[] c = new Client[100];
        for(int i = 0; i < 100; i++){
            c[i] = Client.createClient(String.valueOf(i));
        }
        for(int i = 0; i < 100; i++){
            assert(Client.getClientByAdress(String.valueOf(i)).getId() == i);
        }
    }

    @Test
    void resetClients() {
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
    void testToString() {
        Client c =  Client.createClient("bob");

        assert(c.toString().equals("bob"));
    }

    @Test
    void setPrivateKey() {
    }

    @Test
    void getPrivateKey() {
    }

    @Test
    void generateKeyPair() {
    }

    @Test
    void addKeyringEntry() {
    }

    @Test
    void getKeyringPublicKeyByClient() {
    }

    @Test
    void isKeyPairValid() {
    }

    @Test
    void setAutoResponse() {
    }

    @Test
    void isAutoResponse() {
    }

    @Test
    void autoRespond() {
    }

    @Test
    void getAddressBookReceiversForAlias() {
    }

    @Test
    void addAddressbookEntry() {
    }

    @Test
    void sign() {
    }

    @Test
    void setForwardReceiver() {
    }

    @Test
    void getForwardReceiver() {
    }

    @Test
    void forward() {
    }

    @Test
    void verify() {
    }
}