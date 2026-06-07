import "./UsuarioList.css";

function UsuarioTable({ usuarios }) {
  return (
    <div className="lista-usuarios-container">
      <h1>Lista de Usuarios</h1>
      <table className="tabla-usuarios">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Tipo Documento</th>
            <th>Documento</th>
          </tr>
        </thead>

        <tbody>
          {usuarios.map((usuario) => (
            <tr key={usuario.idUsuario}>
              <td>{usuario.nombre}</td>
              <td>{usuario.apellido}</td>
              <td>{usuario.tipoDocumento}</td>
              <td>{usuario.documento}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UsuarioTable;