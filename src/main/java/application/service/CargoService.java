package application.service;

import application.dto.cargo.CadastrarCargoRequest;
import domain.repository.CargoRepository;
import infrastructure.persistence.CargoRepositoryImpl;

public class CargoService {

    private final CargoRepository cargoRepository = new CargoRepositoryImpl();

    public int buscarOuCadastrarCargo(CadastrarCargoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("O Cargo não Pode ser Nulo.");
        } else {
            int idCargo = cargoRepository.buscarIdCargo(request.nome(), request.departamento());

            if (idCargo <= 0) {
                idCargo = cargoRepository.cadastrarCargo(request.nome(), request.departamento());
            }

            return idCargo;
        }
    }
}
