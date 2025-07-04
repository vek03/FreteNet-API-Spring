package br.com.fatec.fretenetapi.repository.client;

import br.com.fatec.fretenetapi.repository.orm.FreteOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreteRepositoryWithMongo extends MongoRepository<FreteOrm, String> {

}
