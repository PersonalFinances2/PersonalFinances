import "./UsuarioList.css";

function UsuarioTable({ usuarios }) {
  return (
    <table className="tabla-usuarios">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Tipo Documento</th>
          <th>Documento</th>
          <th>Username</th>
        </tr>
      </thead>

      <tbody>
        {usuarios.map((usuario, index) => (
          <tr key={index}>
            <td>{usuario.nombre}</td>
            <td>{usuario.apellido}</td>
            <td>{usuario.tipoDocumento}</td>
            <td>{usuario.documento}</td>
            <td>{usuario.username}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default UsuarioTable;