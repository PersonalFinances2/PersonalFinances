import { useEffect, useState } from "react";
import { crudUsuarios } from "../services/usuarioService";
import UsuarioTable from "../components/usuario/UsuarioList";
import Navbar from "../components/navbar/Navbar";

function UsuarioList() {
  const [usuarios, setUsuarios] = useState([]);

    useEffect(() => {
        obtenerUsuarios();
    }, []);

    async function obtenerUsuarios() {

        try {

            const data = await crudUsuarios(
                "GET",
                "/listaUsuarios"
            );

            setUsuarios(data);

        } catch (error) {
            console.error(error);
        }
    }

  return (
    <div>
      <Navbar />,
      <UsuarioTable usuarios={usuarios} />
    </div>
  );
}

export default UsuarioList;