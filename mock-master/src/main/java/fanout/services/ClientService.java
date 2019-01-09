package fanout.services;

import org.springframework.stereotype.Service;
import fanout.dto.Client;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    public List<Client> getAllClients() {
        return Arrays.asList(Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient());
    }

    public Client getClient(int id) {
        return Mocker.mockClient();
    }
}
