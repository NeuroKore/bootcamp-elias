package com.neurokore.bootcamp.elias.beer.service;

import com.neurokore.bootcamp.elias.beer.dtos.BeerDTO;
import com.neurokore.bootcamp.elias.beer.entities.BeerEntity;
import com.neurokore.bootcamp.elias.beer.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de {@link BeerService} sobre {@link BeerRepository}.
 *
 * <p>Solo {@code save} está implementado; el resto de operaciones están pendientes.</p>
 *
 * @author NeuroKore
 */
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    /**
     * Construye el servicio con sus dependencias.
     *
     * @param beerRepository repositorio de cervezas {@link BeerRepository}
     */
    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    /**
     * Registra una cerveza persistiendo su entidad {@link BeerEntity}.
     *
     * @param beerDTO datos de la cerveza {@link BeerDTO}
     * @return la cerveza registrada {@link BeerDTO}
     */
    @Override
    public BeerDTO save(BeerDTO beerDTO) {

        BeerEntity beerEntity =  new BeerEntity();
        beerEntity.setId(beerDTO.getId());

        BeerEntity entitySaved =  beerRepository.save(beerEntity);

        BeerDTO beerSaved = new BeerDTO();
        beerSaved.setId(entitySaved.getId());

        return beerSaved;
    }

    /**
     * Actualiza una cerveza. Pendiente de implementar: retorna {@code null}.
     *
     * @param beerDTO datos actualizados {@link BeerDTO}
     * @return {@code null} hasta que se implemente
     */
    @Override
    public BeerDTO update(BeerDTO beerDTO) {
        return null;
    }

    /**
     * Elimina una cerveza. Pendiente de implementar: retorna {@code null}.
     *
     * @param beerDTO cerveza a eliminar {@link BeerDTO}
     * @return {@code null} hasta que se implemente
     */
    @Override
    public BeerDTO delete(BeerDTO beerDTO) {
        return null;
    }

    /**
     * Obtiene todas las cervezas. Pendiente de implementar: retorna lista vacía.
     *
     * @return lista vacía hasta que se implemente
     */
    @Override
    public List<BeerDTO> findAll() {
        return List.of();
    }

    /**
     * Obtiene una cerveza por identificador. Pendiente de implementar: retorna {@code null}.
     *
     * @param id identificador de la cerveza
     * @return {@code null} hasta que se implemente
     */
    @Override
    public BeerDTO findById(long id) {
        return null;
    }
}
