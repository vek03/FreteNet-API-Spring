package br.com.fatec.fretenetapi.repository;

import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.exception.InternalServerException;
import br.com.fatec.fretenetapi.exception.NotFoundException;
import br.com.fatec.fretenetapi.repository.adapter.FreteRepositoryAdapter;
import br.com.fatec.fretenetapi.repository.client.FreteRepositoryWithMongo;
import br.com.fatec.fretenetapi.repository.orm.FreteOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class FreteRepositoryImpl implements FreteRepository {
    private static final Logger LOG = LoggerFactory.getLogger(FreteRepositoryImpl.class);

    private final FreteRepositoryWithMongo repository;

    public FreteRepositoryImpl(FreteRepositoryWithMongo repository) {
        this.repository = repository;
    }

    @Override
    public Frete save(Frete frete) {
        try {
            FreteOrm orm = FreteRepositoryAdapter.cast(frete);
            return FreteRepositoryAdapter.cast(repository.save(orm));
        } catch (Exception ex) {
            LOG.error("Erro ao salvar usuario: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    @Override
    public Frete findById(final String id) {
        try {
            Optional<FreteOrm> optional = repository.findById(id);
            if (optional.isEmpty()) {
                throw new NotFoundException("Frete nao existe");
            }
            return FreteRepositoryAdapter.cast(
                    repository.save(optional.get()));
        } catch (NotFoundException ex) {
            LOG.info("Usuario nao encontrado");
            throw ex;
        } catch (Exception ex) {
            LOG.error("Erro ao procurar usuario por id: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    @Override
    public void delete(final String id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            LOG.error("Erro ao deletar usuario: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }
}
