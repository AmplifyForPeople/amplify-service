package webservice.services;

import org.springframework.stereotype.Service;
import webservice.dto.Client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClientService {

    public List<Client> getAllClients() {
        return Arrays.asList(Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient(),Mocker.mockClient());
    }

    public Client getClient(int id) {
        return Mocker.mockClient();
    }
}
