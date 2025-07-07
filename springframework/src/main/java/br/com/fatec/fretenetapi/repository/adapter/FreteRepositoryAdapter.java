package br.com.fatec.fretenetapi.repository.adapter;

import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.repository.orm.FreteOrm;

public class FreteRepositoryAdapter {
    private FreteRepositoryAdapter() {
    }

    public static FreteOrm cast(Frete frete) {
        return new FreteOrm(
                frete.id(),
                frete.idCliente(),
                frete.valorFrete(),
                frete.status(),
                frete.cep(),
                frete.logradouro(),
                frete.complemento(),
                frete.bairro(),
                frete.localidade(),
                frete.uf()
        );
    }

    public static Frete cast(FreteOrm orm) {
        return new Frete(
                orm.id(),
                orm.idCliente(),
                orm.valorFrete(),
                orm.status(),
                orm.cep(),
                orm.logradouro(),
                orm.complemento(),
                orm.bairro(),
                orm.localidade(),
                orm.uf()
        );
    }

}
