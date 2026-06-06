import { useState } from "react";
import "./UsuarioForm.css";

function UsuarioForm({ agregarUsuario }) {
  const [usuario, setUsuario] = useState({
    nombre: "",
    apellido: "",
    tipoDocumento: "",
    documento: "",
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    setUsuario({
      ...usuario,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    agregarUsuario(usuario);

    setUsuario({
      nombre: "",
      apellido: "",
      tipoDocumento: "",
      documento: "",
      username: "",
      password: "",
    });
  };

  return (
    <div className="usuario-container">
      <h2>Registro de Usuario</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="nombre"
          placeholder="Nombre"
          onChange={handleChange}
        />

        <input
          type="text"
          name="apellido"
          placeholder="Apellido"
          value={usuario.nombre}
          onChange={handleChange}
        />

        <select name="tipoDocumento"
          value={usuario.tipoDocumento}
          onChange={handleChange}>
          <option value="" disabled>Tipo de Documento</option>
          <option value="CC">CC</option>
          <option value="TI">TI</option>
          <option value="CE">CE</option>
        </select>

        <input
          type="number"
          name="documento"
          placeholder="Documento"
          onChange={handleChange}
        />

        <input
          type="text"
          name="username"
          placeholder="Username"
          onChange={handleChange}
        />

        <input
          type="password"
          name="password"
          placeholder="Contraseña"
          onChange={handleChange}
        />

        <button type="submit">Guardar</button>
      </form>
    </div>
  );
}

export default UsuarioForm;