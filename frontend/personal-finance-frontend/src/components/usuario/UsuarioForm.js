import { useState } from "react";
import "./UsuarioForm.css";

function UsuarioForm() {
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
    e.preventDefault();
    console.log(usuario);
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
          onChange={handleChange}
        />

        <select name="tipoDocumento" onChange={handleChange}>
          <option value="">Seleccione</option>
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