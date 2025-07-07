package br.com.fatec.fretenetapi.repository.adapter;

import br.com.fatec.fretenetapi.entity.Endereco;
import br.com.fatec.fretenetapi.entity.Frete;
import br.com.fatec.fretenetapi.repository.orm.EnderecoOrm;
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
                cast(frete.endereco())
        );
    }

    public static Frete cast(FreteOrm freteOrm) {
        return new Frete(
                freteOrm.id(),
                freteOrm.idCliente(),
                freteOrm.valorFrete(),
                freteOrm.status(),
                cast(freteOrm.endereco())
        );
    }

    public static EnderecoOrm cast(Endereco endereco){
        return new EnderecoOrm(
                endereco.cep(),
                endereco.logradouro(),
                endereco.complemento(),
                endereco.bairro(),
                endereco.localidade(),
                endereco.uf()
        );
    }

    public static Endereco cast(EnderecoOrm enderecoOrm){
        return new Endereco(
                enderecoOrm.cep(),
                enderecoOrm.logradouro(),
                enderecoOrm.complemento(),
                enderecoOrm.bairro(),
                enderecoOrm.localidade(),
                enderecoOrm.uf()
        );
    }
}