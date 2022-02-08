package EmailSystem;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void createClient() {
    }

    @Test
    void getClientById() {
    }

    @Test
    void getClientByAdress() {
    }

    @Test
    void resetClients() {
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