package BackEnd.Sevice;

import BackEnd.Model.Usuario.Cargo;
import BackEnd.Model.Usuario.Cliente;
import BackEnd.Model.Usuario.Usuario;

public class UsuarioService {

    public void adicionarUsuarioDoCliente(Cliente cliente, Cargo cargo){

        Usuario usuario = new Usuario();

        usuario.setNome(cliente.getNome());
        usuario.setDocumento(cliente.getDocumento());
        usuario.setLogin(cliente.get);
    }

    public void criarEndereco(Usuario usuario){

    }

    public void cadastraCargoUsuario(Usuario usuario, Cargo cargo){

    }

}
