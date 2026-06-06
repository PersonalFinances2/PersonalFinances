import { useState } from "react";
import UsuarioTable from "../components/usuario/UsuarioList";

function UsuarioList() {
  const [usuarios, setUsuarios] = useState([]);

  return (
    <div>
      <h1>Lista de Usuarios</h1>

      <UsuarioTable usuarios={usuarios} />
    </div>
  );
}

export default UsuarioList;