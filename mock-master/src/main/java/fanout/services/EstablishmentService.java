package fanout.services;

import org.springframework.stereotype.Service;
import fanout.dto.Establishment;

import java.util.Arrays;
import java.util.List;

@Service
public class EstablishmentService {

    public List<Establishment> getAllEstablishments() {
        return Arrays.asList(Mocker.mockEstablishment(),Mocker.mockEstablishment(),Mocker.mockEstablishment(),Mocker.mockEstablishment(),Mocker.mockEstablishment());
    }

    public Establishment getSimilarEstablishment(int id) {
        return Mocker.mockEstablishment();
    }

    public List<Establishment> getSimilarListEstablishment(int id) {
        return Arrays.asList(Mocker.mockEstablishment(), Mocker.mockEstablishment());
    }
}
